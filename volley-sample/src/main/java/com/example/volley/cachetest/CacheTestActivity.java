package com.example.volley.cachetest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.volley.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by xiongcen on 16/11/25.
 */

public class CacheTestActivity extends Activity {

    private final String TAG = getClass().getSimpleName();
    ImageView img;
    Button msg;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cache_test_main);

//        openCache();

        img = (ImageView) findViewById(R.id.imageView1);
        tv = (TextView) findViewById(R.id.textView1);
        msg = (Button) findViewById(R.id.button1);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InternetTask().execute();
            }
        });
    }

    private void openCache() {
        try {
            File httpCacheDir = new File(getCacheDir(), "http");
            long httpCacheSize = 10 * 1024 * 1024; // 10 MiB
            HttpResponseCache.install(httpCacheDir, httpCacheSize);
        } catch (IOException e) {
            Log.i("===>", "HTTP response cache installation failed:" + e);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
//        closeCache();
    }

    private void closeCache() {
        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache != null) {
            cache.flush();
        }
    }

    class InternetTask extends AsyncTask<String, String, Boolean> {
        Bitmap bitmap;
        String jsonStr;

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            img.setImageBitmap(bitmap);
            tv.setText(jsonStr);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            // Test download image
            try {
                URL url = new URL("http://news.baidu.com/resource/img/logo_news_137_46.png");
                HttpURLConnection conn = (HttpURLConnection) (url
                        .openConnection());
                conn.connect();
                InputStream is = conn.getInputStream();
                BitmapFactory.Options ops = new BitmapFactory.Options();
                bitmap = BitmapFactory.decodeStream(is, null, ops);
                is.close();
                conn.disconnect();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }

            // Test download JSON data
            try {
                URL url = new URL("http://www.baidu.com/");
                HttpURLConnection conn = (HttpURLConnection) (url
                        .openConnection());
                conn.connect();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                jsonStr = reader.readLine();
                InputStream is = conn.getInputStream();
                is.close();
                conn.disconnect();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
            return true;
        }

    }
}
