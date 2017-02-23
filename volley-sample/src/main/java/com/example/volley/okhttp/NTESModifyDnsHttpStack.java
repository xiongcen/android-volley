package com.example.volley.okhttp;

import android.content.Context;

import okhttp3.OkHttpClient;

/**
 * Created by xiongcen on 17/2/16.
 */

public class NTESModifyDnsHttpStack extends OKHttpStack {

    public NTESModifyDnsHttpStack(OkHttpClient client, Context context) {
        super(client, context);
    }
}
