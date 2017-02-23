package com.example.volley.okhttp;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.HttpStack;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.http.HttpResponse;

import javax.net.ssl.HostnameVerifier;

import okhttp3.OkHttpClient;

/**
 * Created by xiongcen on 17/2/15.
 */

public class OKHttpStack implements HttpStack {

    private final OkHttpClient mClient;
    final Context mContext;

    public OKHttpStack(OkHttpClient client, Context context) {
        this.mClient = client;
        this.mContext = context;
    }

    /**
     * 设置实际请求时使用的url 如果为null 则使用原url
     *
     * @param request
     * @return
     * @throws MalformedURLException
     */
    protected URL getRequestURL(Request<?> request) throws MalformedURLException {
        return new URL(request.getUrl());
    }

    @Override
    public HttpResponse performRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
//        URL customRequestURL = getRequestURL(request);
//        OkHttpClient.Builder okHttpClientBuilder = mClient.newBuilder();
//        HostnameVerifier hostnameVerifier =
        return null;
    }
}
