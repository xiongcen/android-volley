/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;

import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.protocol.HTTP;

import java.util.Map;

/** Http header 的解析工具类，在 Volley 中主要作用是用于解析 Header 从而判断返回结果是否需要缓存。
 * Utility methods for parsing HTTP headers.
 */
public class HttpHeaderParser {

    /** 通过网络响应中的缓存控制 Header 和 Body 内容，构建缓存实体。
     *
     * 1.没有处理Last-Modify首部，而是处理存储了Date首部，并在后续的新鲜度验证时，
     * 使用Date来构建If-Modified-Since。 这与 Http 1.1 的语义有些违背。
     * 2.计算过期时间，Cache－Control 首部优先于 Expires 首部。
     * Extracts a {@link Cache.Entry} from a {@link NetworkResponse}.
     *
     * @param response The network response to parse headers from
     * @return a cache entry for the given response, or null if the response is not cacheable.
     */
    public static Cache.Entry parseCacheHeaders(NetworkResponse response) {
        long now = System.currentTimeMillis();

        Map<String, String> headers = response.headers;

        long serverDate = 0;
        long lastModified = 0;
        long serverExpires = 0;
        long softExpire = 0;
        long finalExpire = 0;
        long maxAge = 0;
        // 陈旧而重新验证的时间
        long staleWhileRevalidate = 0;
        boolean hasCacheControl = false;
        // 必须重新验证
        boolean mustRevalidate = false;

        String serverEtag = null;
        String headerValue;

        headerValue = headers.get("Date");
        if (headerValue != null) {
            // 根据 Date 首部，获取响应生成时间
            serverDate = parseDateAsEpoch(headerValue);
        }

        // 获取响应提的Cache缓存策略
        headerValue = headers.get("Cache-Control");
        if (headerValue != null) {
            hasCacheControl = true;
            String[] tokens = headerValue.split(",");
            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i].trim();
                // 如果 Header 的 Cache-Control 字段含有no-cache或no-store表示不缓存
                if (token.equals("no-cache") || token.equals("no-store")) {
                    return null;
                } else if (token.startsWith("max-age=")) {
                    // 获取缓存的有效时间，单位是秒
                    try {
                        maxAge = Long.parseLong(token.substring(8));
                    } catch (Exception e) {
                    }
                } else if (token.startsWith("stale-while-revalidate=")) {
                    // 是过了缓存时间后还可以继续使用缓存的时间，单位是秒
                    // 所以真正的缓存时间是“max-age=” + “stale-while-revalidate=”的总时间
                    // 但如果有“must-revalidate”或者“proxy-revalidate”字段则过了缓存时间缓存就立即请求服务器
                    try {
                        staleWhileRevalidate = Long.parseLong(token.substring(23));
                    } catch (Exception e) {
                    }
                } else if (token.equals("must-revalidate") || token.equals("proxy-revalidate")) {
                    // 过了缓存时间就立刻请求服务器
                    mustRevalidate = true;
                }
            }
        }

        // 缓存有效期的时间点，和Cache-Control意思一致，为兼容HTTP1.0和HTTP1.1才会使用该字段
        // 如果有Cache-Control，优先使用Cache-Control
        headerValue = headers.get("Expires");
        if (headerValue != null) {
            serverExpires = parseDateAsEpoch(headerValue);
        }

        // 服务器最后修改的时间
        headerValue = headers.get("Last-Modified");
        if (headerValue != null) {
            lastModified = parseDateAsEpoch(headerValue);
        }

        // 根据 ETag 首部，获取响应实体标签。
        // 该字段是服务器资源的唯一标识符，与"Last-Modified"配合使用
        // 因为"Last-Modified"只能精确到秒，如果"ETag"与服务器一致，再判断"Last-Modified"
        // 防止一秒内服务器多次修改而导致数据不准确的问题
        serverEtag = headers.get("ETag");

        // Cache-Control takes precedence over an Expires header, even if both exist and Expires
        // is more restrictive.
        // 根据 Cache－Control 和 Expires 首部，计算出缓存的过期时间，和缓存的新鲜度时间
        if (hasCacheControl) {
            // 最精确的缓存过期时间softExpire=现在的时间+缓存可使用的最大时间
            softExpire = now + maxAge * 1000;
            // 最终缓存过期时间finalExpire，还要判断mustRevalidate参数
            // 如果mustRevalidate=false
            // 最终缓存过期时间finalExpire=最精确的缓存过期时间softExpire+缓存过期后还可以继续使用的时间
            finalExpire = mustRevalidate
                    ? softExpire
                    : softExpire + staleWhileRevalidate * 1000;
        } else if (serverDate > 0 && serverExpires >= serverDate) {
            // Default semantic for Expire header in HTTP specification is softExpire.
            // 如果 响应生成时间点>0 && 缓存有效期的时间点>=响应生成时间点
            // 最精确的缓存过期时间softExpire=现在的时间+(缓存有效期的时间点-响应生成时间点)
            softExpire = now + (serverExpires - serverDate);
            // 最终缓存过期时间finalExpire=最精确的缓存过期时间softExpire
            finalExpire = softExpire;
        }

        Cache.Entry entry = new Cache.Entry();
        entry.data = response.data;
        entry.etag = serverEtag;
        entry.softTtl = softExpire;
        entry.ttl = finalExpire;
        entry.serverDate = serverDate;
        entry.lastModified = lastModified;
        entry.responseHeaders = headers;

        return entry;
    }

    /** 解析时间，将 RFC1123 的时间格式，解析成 epoch 时间
     * Parse date in RFC1123 format, and return its value as epoch
     */
    public static long parseDateAsEpoch(String dateStr) {
        try {
            // Parse date in RFC1123 format if this header contains one
            return DateUtils.parseDate(dateStr).getTime();
        } catch (DateParseException e) {
            // Date in invalid format, fallback to 0
            return 0;
        }
    }

    /** 解析编码集，在 Content-Type 首部中获取编码集，如果没有找到，返回defaultCharset
     * Retrieve a charset from headers
     *
     * @param headers An {@link java.util.Map} of headers
     * @param defaultCharset Charset to return if none can be found
     * @return Returns the charset specified in the Content-Type of this header,
     * or the defaultCharset if none can be found.
     */
    public static String parseCharset(Map<String, String> headers, String defaultCharset) {
        String contentType = headers.get(HTTP.CONTENT_TYPE);
        if (contentType != null) {
            String[] params = contentType.split(";");
            for (int i = 1; i < params.length; i++) {
                String[] pair = params[i].trim().split("=");
                if (pair.length == 2) {
                    if (pair[0].equals("charset")) {
                        return pair[1];
                    }
                }
            }
        }

        return defaultCharset;
    }

    /** 解析编码集，在 Content-Type 首部中获取编码集，如果没有找到，默认返回 ISO-8859-1
     * Returns the charset specified in the Content-Type of this header,
     * or the HTTP default (ISO-8859-1) if none can be found.
     */
    public static String parseCharset(Map<String, String> headers) {
        return parseCharset(headers, HTTP.DEFAULT_CONTENT_CHARSET);
    }
}
