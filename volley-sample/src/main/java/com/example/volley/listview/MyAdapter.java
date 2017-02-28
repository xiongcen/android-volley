package com.example.volley.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.volley.R;

/**
 * Created by xiongcen on 17/2/27.
 */

public class MyAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private Context context;

    MyAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context.getApplicationContext());
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type) {
            case 0: {
                ViewHolder1 holder = null;
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.listview_item, null);
                    holder = new ViewHolder1();
                    holder.textView = (TextView) convertView.findViewById(R.id.text);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder1) convertView.getTag();
                }
                holder.textView.setText("这是第" + position + "个");
                break;
            }
            case 1: {
                ViewHolder2 holder = null;
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.listview_item2, null);
                    holder = new ViewHolder2();
                    holder.imageView = (ImageView) convertView.findViewById(R.id.image);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder2) convertView.getTag();
                }
                holder.imageView.setImageResource(R.drawable.ic_launcher);
                break;
            }
            default:
                break;
        }

        return convertView;
    }

    class ViewHolder1 {
        TextView textView;
    }

    class ViewHolder2 {
        ImageView imageView;
    }
}
