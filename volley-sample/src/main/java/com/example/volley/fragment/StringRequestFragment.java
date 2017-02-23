package com.example.volley.fragment;

import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.volley.R;
import com.example.volley.util.Constants;
import com.example.volley.util.StringUtil;
import com.example.volley.util.ToastUtil;
import com.example.volley.util.VolleyUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class StringRequestFragment extends Fragment {
	public static final int INDEX = 11;

	private EditText etUrl;
	private Button btnSend;
	private TextView tvResult;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fr_string_request, container,false);

		initView(view);

		return view;
	}

	private void initView(View view) {
		etUrl = (EditText) view.findViewById(R.id.et_url);
		btnSend = (Button) view.findViewById(R.id.btn_send);
		tvResult = (TextView) view.findViewById(R.id.tv_result);

		etUrl.setText(Constants.DEFAULT_STRING_REQUEST_URL);

		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (StringUtil.isEmpty(etUrl.getText().toString())) {
					ToastUtil.showToast(getActivity(), "请输入请求地址");
					return;
				}
				/**
				 * ----------volley请求----------
				 */
				//请求之前，先取消之前的请求（取消还没有进行完的请求）
//				VolleyUtil.cancelAll(this);
//				tvResult.setText("");
//
//				final StringRequest request = new StringRequest(StringUtil.preUrl(etUrl.getText().toString().trim()),
//						new Listener<String>() {
//
//							@Override
//							public void onResponse(String response) {
//								tvResult.setText(response);
//
//							}
//						}, new ErrorListener() {
//
//							@Override
//							public void onErrorResponse(VolleyError arg0) {
//								ToastUtil.showToast(getActivity(), getResources().getString(R.string.request_fail_text));
//
//							}
//						});
//				//请求加上Tag,用于取消请求
//				request.setTag(this);
//
//
//				VolleyUtil.addRequest(request);

				/**
				 * ----------okhttp请求----------
				 */
				OkHttpClient okHttpClient = new OkHttpClient();
				final Request request1 = new Request.Builder().url(etUrl.getText().toString()).build();
				Call call = okHttpClient.newCall(request1);
				call.enqueue(new Callback() {
					@Override
					public void onFailure(Call call, IOException e) {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								ToastUtil.showToast(getActivity(), getResources().getString(R.string.request_fail_text));
							}
						});
					}

					@Override
					public void onResponse(Call call, Response response) throws IOException {
						// 非UI线程
						Log.d("StringRequestFragment", "is Main thread:"+(Looper.myLooper() == Looper.getMainLooper()));
						final String res = response.body().string();
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								tvResult.setText(res);
							}

						});
					}
				});

			}
		});
	}

	@Override
	public void onDestroyView() {
		VolleyUtil.cancelAll(this);
		super.onDestroyView();
	}
	
	
	

}
