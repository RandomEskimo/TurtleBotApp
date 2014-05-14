package com.example.turtlebotproject;

import android.os.Bundle;

public class figure8Activity extends MainActivity	{

	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.figure8);
		addListenerOnButton();
	}
}