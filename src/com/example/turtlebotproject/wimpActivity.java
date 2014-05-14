package com.example.turtlebotproject;

import android.os.Bundle;

public class wimpActivity extends MainActivity	{

	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wimp);
		addListenerOnButton();
	}
}