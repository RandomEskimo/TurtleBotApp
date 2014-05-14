package com.example.turtlebotproject;

import android.os.Bundle;

public class cover_dockActivity extends MainActivity	{

	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cover_dock);
		addListenerOnButton();
	}
}