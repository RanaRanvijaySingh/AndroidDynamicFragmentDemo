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
public class FirstFragment extends Fragment implements OnClickListener {

	MainActivity mActivity;

	@SuppressLint("ValidFragment")
	public FirstFragment(MainActivity mainActivity) {
		mActivity = mainActivity;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.first_fragment, container, false);

		Button buttonFirst = (Button) view.findViewById(R.id.first_button);
		buttonFirst.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		Log.v(null, "reached");
		mActivity.getFragment(mActivity.SECOND);

	}

}
