package com.webonise.dynamicfragmentbasic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("ValidFragment")
public class SecondFragment extends Fragment implements OnClickListener{
	MainActivity mActivity;
	@SuppressLint("ValidFragment")
	SecondFragment(MainActivity mainActivity) {
		mActivity=mainActivity;
	}

	@SuppressLint("ValidFragment")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.second_fragment, container, false);
		Button buttonSecond=(Button)view.findViewById(R.id.second_button);
		buttonSecond.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		Log.v(null,"second button pressed");
		mActivity.getFragment(mActivity.FIRST);
	}
}
