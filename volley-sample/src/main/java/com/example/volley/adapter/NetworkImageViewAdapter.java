package com.example.volley.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.volley.R;
import com.example.volley.util.LruImageCache;
import com.example.volley.util.StringUtil;
import com.example.volley.util.VolleyUtil;

public class NetworkImageViewAdapter extends ImageBaseAdapter{

	private ImageLoader imageLoader;
	
	public NetworkImageViewAdapter(Context context, String[] imageUrlArray) {
		super(context, imageUrlArray);
		this.imageLoader=new ImageLoader(VolleyUtil.getQueue(context), new LruImageCache());
	}

	@Override
	int getItemLayout() {
		return R.layout.fr_network_image_view_list_item;
	}

	@Override
	void setImage(ImageView imageView, String imageUrl) {
		NetworkImageView networkImageView=(NetworkImageView)imageView;
		networkImageView.setDefaultImageResId(R.drawable.ic_empty);  
		networkImageView.setErrorImageResId(R.drawable.ic_empty);  
		networkImageView.setImageUrl(StringUtil.preUrl(imageUrl),  imageLoader);
	}

}
