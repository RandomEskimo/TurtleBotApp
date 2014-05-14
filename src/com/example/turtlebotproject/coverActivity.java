package com.example.turtlebotproject;

import android.os.Bundle;

public class coverActivity extends MainActivity	{

	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cover);
		addListenerOnButton();
	}
}