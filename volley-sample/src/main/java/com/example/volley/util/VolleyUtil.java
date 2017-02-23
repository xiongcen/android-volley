package com.example.volley.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.NoCache;
import com.android.volley.toolbox.Volley;
import com.example.volley.okhttp.HttpLoggingInterceptor;
import com.example.volley.okhttp.NTESModifyDnsHttpStack;
import com.example.volley.okhttp.OKHttpManager;
import com.example.volley.okhttp.OKHttpStack;

import okhttp3.OkHttpClient;

public class VolleyUtil {

    private static final String TAG = "Volley";
    private static VolleyUtil sVolleyUtil;
    private static Context mContext;
    private RequestQueue mRequestQueue;

    private VolleyUtil() {
        mRequestQueue = newRequestQueue(newHttpStack());
        mRequestQueue.start();
    }

    private static VolleyUtil getInstance() {
        if (mContext == null) {
            Log.e(TAG, "must init the VolleyManager before use...");
            throw new RuntimeException("must init the VolleyManager before use...");
        }
        if (sVolleyUtil == null) {
            synchronized (VolleyUtil.class) {
                if (sVolleyUtil == null) {
                    sVolleyUtil = new VolleyUtil();
                }
            }
        }
        return sVolleyUtil;
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static void addRequest(Request request) {
        if (request == null) {
            return;
        }

        getInstance().mRequestQueue.add(request);
    }

    public static void cancelAll(final Object tag) {
        getInstance().mRequestQueue.cancelAll(tag);
    }

    public static RequestQueue getRequestQueue() {
        return getInstance().mRequestQueue;
    }

    private HttpStack newHttpStack() {
        HttpStack stack = null;

        OkHttpClient.Builder builder = OKHttpManager.getInstance().getOkHttpClient().newBuilder().addInterceptor(new HttpLoggingInterceptor());
        OkHttpClient client = builder.build();

        if (isHttpDNSEnabled()) {
            stack = new NTESModifyDnsHttpStack(client, mContext);
        }

        if (stack == null) {
            stack = new OKHttpStack(client, mContext);
        }
        return stack;
    }

    private RequestQueue newRequestQueue(HttpStack stack) {
        BasicNetwork network = new BasicNetwork(stack);
        return new RequestQueue(new NoCache(), network);
    }

    public static boolean isHttpDNSEnabled() {
        return true;
    }
}
