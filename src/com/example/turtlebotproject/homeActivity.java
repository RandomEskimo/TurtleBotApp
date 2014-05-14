package com.example.turtlebotproject;

import android.os.Bundle;

public class homeActivity extends MainActivity	{

	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		addListenerOnButton();
	}
}