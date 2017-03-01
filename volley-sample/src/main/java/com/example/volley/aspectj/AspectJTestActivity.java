package com.example.volley.aspectj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.volley.R;

import org.aspectj.lang.annotation.Aspect;

/**
 * Created by xiongcen on 17/2/28.
 */

public class AspectJTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
        testAOP();
    }

    public void testAOP() {
        Log.d("xiongcen", "testAOP");
    }
}
