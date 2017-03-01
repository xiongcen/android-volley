package com.example.volley.aspectj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.volley.R;

/**
 * Created by xiongcen on 17/2/28.
 */

public class AspectJTestActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
        testAOP1();
        testAOP2();
    }

    public void testAOP() {
        Log.d("xiongcen", "testAOP");
    }

    public void testAOP1() {
        testAOP();
    }

    public void testAOP2() {
        testAOP();
    }
}
