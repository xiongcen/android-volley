package com.example.volley.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/**
 * Created by xiongcen on 17/2/16.
 */

public class OKHttpManager {

    private static OKHttpManager sInstance = new OKHttpManager();
    private static final int MAX_REQUESTS_PER_HOST = 10;
    public static final int DEFAULT_READ_TIMEOUT_MILLIS = 15 * 1000;
    public static final int DEFAULT_WRITE_TIMEOUT_MILLIS = 15 * 1000;
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 15 * 1000;
    private OkHttpClient mOkHttpClient;

    public static OKHttpManager getInstance() {
        return sInstance;
    }

    private OKHttpManager() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(MAX_REQUESTS_PER_HOST);

        mOkHttpClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .addNetworkInterceptor(new GzipRequestInterceptor())//添加压缩的拦截器
                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
