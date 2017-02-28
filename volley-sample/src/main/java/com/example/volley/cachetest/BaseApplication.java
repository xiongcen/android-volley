package com.example.volley.cachetest;

import android.app.Application;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.example.volley.util.VolleyUtil;

import java.io.File;

/**
 * Created by xiongcen on 16/11/25.
 */

public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        VolleyUtil.init(this);

        new Thread() {
            @Override
            public void run() {
                enableHttpResponseCache();
            }
        }.start();
    }

    private void enableHttpResponseCache() {
        try {
            long httpCacheSize = 10 * 1024 * 1024;// 10M
            File httpCacheDir = new File(getCacheDir(), "http");
            Class.forName("android.net.http.HttpResponseCache")
                    .getMethod("install", File.class, long.class)
                    .invoke(null, httpCacheDir, httpCacheSize);
        } catch (Exception e) {
            Log.e("===>", e.getMessage(), e);
        }
    }
}
