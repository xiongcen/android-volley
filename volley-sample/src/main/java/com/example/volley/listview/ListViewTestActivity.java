package com.example.volley.listview;

import android.app.Activity;
import android.os.Bundle;

import com.example.volley.R;

/**
 * Created by xiongcen on 17/2/27.
 */

public class ListViewTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_listview_test);

        MyListView listView = (MyListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
    }
}
