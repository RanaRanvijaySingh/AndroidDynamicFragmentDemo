package com.webonise.dynamicfragmentbasic;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

	public static final int FIRST = 0;
	public static final int SECOND = 1;
	FirstFragment firstFragment;
	SecondFragment secondFragment;
	FragmentManager fragmentManager=getSupportFragmentManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		firstFragment = new FirstFragment(this);
		secondFragment = new SecondFragment(this);

		firstFragment.setArguments(getIntent().getExtras());
		secondFragment.setArguments(getIntent().getExtras());
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.fragments, firstFragment).commit();
	}

	void getFragment(int intFragment) {

		if (intFragment == FIRST) {
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			transaction.replace(R.id.fragments, firstFragment);
			transaction.commit();
		} else {
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			transaction.replace(R.id.fragments, secondFragment);
			transaction.commit();
		}
		
		
	}
}
