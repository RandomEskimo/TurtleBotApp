package com.example.turtlebotproject;

import android.os.Bundle;

public class spot_coverActivity extends MainActivity	{

	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spot_cover);
		addListenerOnButton();
	}
}