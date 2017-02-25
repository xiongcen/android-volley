package com.example.volley;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.volley.cachetest.CacheTestActivity;
import com.example.volley.fragment.ImageLoaderFragment;
import com.example.volley.fragment.ImageRequestFragment;
import com.example.volley.fragment.JsonRequestFragment;
import com.example.volley.fragment.NetworkImageViewFragment;
import com.example.volley.fragment.PostRequestFragment;
import com.example.volley.fragment.StringRequestFragment;
import com.example.volley.fragment.XmlRequestFragment;
import com.example.volley.inject.Inject;
import com.example.volley.inject.MInject;
import com.example.volley.inject.OnClick;
import com.example.volley.util.Constants;
import com.example.volley.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends Activity implements OnClickListener {

    private static final String TAG = "HomeActivity";

    @Inject(value = R.id.btn_string_request)
    private Button stringBtn;

    @BindView(R.id.btn_json_request)
    Button jsonBtn;

    private int clickCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);


        int i = 1;
        ClassLoader classLoader = getClassLoader();
        if (classLoader != null) {
            Log.i(TAG, "[onCreate] classLoader " + i + " : " + classLoader.toString());
            while (classLoader.getParent() != null) {
                i++;
                classLoader = classLoader.getParent();
                Log.i(TAG, "[onCreate] classLoader " + i + " : " + classLoader.toString());
            }
        }

        MInject.inject(this);

        ButterKnife.bind(this);

        initView();
    }

    @OnClick(value = R.id.btn_string_request, shakeTime = 5000)
    public void click(View view) {
        clickCount++;
        ToastUtil.showToast(this, "测试"+clickCount);
    }

    private void initView() {
        // String请求
        findViewById(R.id.btn_string_request).setOnClickListener(this);

        // Json请求
        jsonBtn.setOnClickListener(this);

        // Image请求
        findViewById(R.id.btn_image_request).setOnClickListener(this);

        // ImageLoader
        findViewById(R.id.btn_image_loader).setOnClickListener(this);

        // NetworkImageView
        findViewById(R.id.btn_network_image_view).setOnClickListener(this);

        // Xml请求
        findViewById(R.id.btn_xml_request).setOnClickListener(this);

        // post请求
        findViewById(R.id.btn_post_request).setOnClickListener(this);

        findViewById(R.id.btn_cache_test).setOnClickListener(this);

        findViewById(R.id.btn_socket_test).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HomeActivity.this, RequestActivity.class);
        switch (v.getId()) {
            case R.id.btn_string_request:
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, StringRequestFragment.INDEX);
                break;
            case R.id.btn_json_request:
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, JsonRequestFragment.INDEX);
                break;
            case R.id.btn_image_request:
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, ImageRequestFragment.INDEX);
                break;
            case R.id.btn_image_loader:
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, ImageLoaderFragment.INDEX);
                break;
            case R.id.btn_network_image_view:
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, NetworkImageViewFragment.INDEX);
                break;
            case R.id.btn_xml_request:
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, XmlRequestFragment.INDEX);
                break;
            case R.id.btn_post_request:
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, PostRequestFragment.INDEX);
                break;
            case R.id.btn_socket_test:
                startActivity(new Intent(HomeActivity.this, SocketActivity.class));
                break;
            case R.id.btn_cache_test:
                startActivity(new Intent(HomeActivity.this, CacheTestActivity.class));
                return;
            default:
                break;
        }

        startActivity(intent);

    }

}
