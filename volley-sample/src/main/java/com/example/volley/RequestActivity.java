package com.example.volley;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.volley.fragment.ImageLoaderFragment;
import com.example.volley.fragment.ImageRequestFragment;
import com.example.volley.fragment.JsonRequestFragment;
import com.example.volley.fragment.NetworkImageViewFragment;
import com.example.volley.fragment.PostRequestFragment;
import com.example.volley.fragment.StringRequestFragment;
import com.example.volley.fragment.XmlRequestFragment;
import com.example.volley.util.Constants;


public class RequestActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int frIndex = getIntent().getIntExtra(Constants.Extra.FRAGMENT_INDEX, 0);
        Fragment fr;
        String tag;
        int titleRes;
        switch (frIndex) {
            default:
            case StringRequestFragment.INDEX:
                tag = StringRequestFragment.class.getSimpleName();
                fr = getSupportFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new StringRequestFragment();
                }
                titleRes = R.string.string_request;
                break;
            case JsonRequestFragment.INDEX:
                tag = JsonRequestFragment.class.getSimpleName();
                fr = getSupportFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new JsonRequestFragment();
                }
                titleRes = R.string.json_request;
                break;
            case ImageRequestFragment.INDEX:
                tag = ImageRequestFragment.class.getSimpleName();
                fr = getSupportFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new ImageRequestFragment();
                    fr.setArguments(getIntent().getExtras());
                }
                titleRes = R.string.image_request;
                break;
            case ImageLoaderFragment.INDEX:
                tag = ImageLoaderFragment.class.getSimpleName();
                fr = getSupportFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new ImageLoaderFragment();
                }
                titleRes = R.string.image_loader;
                break;
            case NetworkImageViewFragment.INDEX:
                tag = NetworkImageViewFragment.class.getSimpleName();
                fr = getSupportFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new NetworkImageViewFragment();
                }
                titleRes = R.string.network_image_view;
                break;
            case XmlRequestFragment.INDEX:
                tag = XmlRequestFragment.class.getSimpleName();
                fr = getSupportFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new XmlRequestFragment();
                }
                titleRes = R.string.xml_request;
                break;
            case PostRequestFragment.INDEX:
                tag = PostRequestFragment.class.getSimpleName();
                fr = getSupportFragmentManager().findFragmentByTag(tag);
                if (fr == null) {
                    fr = new PostRequestFragment();
                }
                titleRes = R.string.post_request;
                break;

        }

        setTitle(titleRes);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fr, tag).commit();
    }
}
