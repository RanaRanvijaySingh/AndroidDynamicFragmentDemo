AndroidDynamicFragmentDemo
==========================
This application sample will show you how to handle the fragments in a application based on the user click.
GitHub link : https://github.com/ranvijaySingh-Webonise/AndroidDynamicFragmentDemo
There are very specific steps to do this .

Step 1: Create your layout for the fragments .
Step 2: create your fragments classes.
Step 3 : Create your main Activity “MainActivity.java”

Now to understand the concept of fragment you need to know about few function and methods that fragments need to execute .

FragmentManager :   (Abstract Class) - interface to interact with the fragment with Activity.
FragmentTransaction : (Abstract Class) - API for performing a set of Fragment operations.
--- Transaction should be performed every time you shift from one fragment to another----
- FUNCTIONS-
		-add() : adds a complete new Fragment to the UI.
-remove() : removes the fragment from the activity.
-replace() : replace the existing fragment that was added to layout. 
-commit() : make you fragment visible to the UI.
	---there cannot be more than one commit on a fragment ---
      ---if you need to commit the present fragment , replace or remove the previous fragment---
____________________________________________________________________________________________________________________________________________________________
____________________________________________________________________________________________________________________________________________________________
Now your “activity_main.xml”

    <FrameLayout
        android:id="@+id/fragments"
        android:layout_width="match_parent"
        android:layout_height="match_parent" >
    </FrameLayout>

____________________________________________________________________________________________________________________________________________________________
Step 2: create your fragments classes.
 “FirstFragment.java”

		View view = inflater.inflate(R.layout.first_fragment, container, false);

		Button buttonFirst = (Button) view.findViewById(R.id.first_button);
		buttonFirst.setOnClickListener(this);


	public void onClick(View v) {
		Log.v(null, "reached");
		mActivity.getFragment(mActivity.SECOND);


____________________________________________________________________________________________________________________________________________________________
Your second fragment “SecondFragment.java”

		View view = inflater
				.inflate(R.layout.second_fragment, container, false);
		Button buttonSecond = (Button) view.findViewById(R.id.second_button);
		buttonSecond.setOnClickListener(this);


	@Override
	public void onClick(View v) {
		Log.v(null, "second button pressed");
		mActivity.getFragment(mActivity.FIRST);
	}

____________________________________________________________________________________________________________________________________________________________

	FragmentManager fragmentManager=getSupportFragmentManager();

		firstFragment = new FirstFragment(this);
		secondFragment = new SecondFragment(this);

		firstFragment.setArguments(getIntent().getExtras());
		secondFragment.setArguments(getIntent().getExtras());
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.fragments, firstFragment).commit();

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


