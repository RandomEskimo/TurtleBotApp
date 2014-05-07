package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity3 extends MainActivity	{
	
	Button button;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {
   	 
		final Context context = this;
 
		Button button = (Button) findViewById(R.id.button1);
 
		button.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, joystickActivity.class);
                            startActivity(intent);   
 
			}
 
		});
	
}
 
}

