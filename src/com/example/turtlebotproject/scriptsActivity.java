package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class scriptsActivity extends MainActivity {
	
	// create buttons
	Button joyButton;
	Button scriptButton;
	Button accButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scripts);
		
		// setup button listeners
		addListenerOnButton12();
		addListenerOnButton13();
		addListenerOnButton14();
	}
	

	// button for going to Joystick page
	public void addListenerOnButton12() {
	   	 
		final Context context = this;
 
		// assign buttons to xml button ids
		joyButton = (Button) findViewById(R.id.button12);

		// joystick activity
		joyButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, joystickActivity.class);
                            startActivity(intent);   
			}
		});
	}

	// button for going to Scripts page
	public void addListenerOnButton13() {
	   	 
		final Context context = this;
 
		// assign buttons to xml button ids
		scriptButton = (Button) findViewById(R.id.button13);
 
		//scripts activity
		scriptButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
	 
			    Intent intent = new Intent(context, scriptsActivity.class);
                startActivity(intent);   
	 
			}
		});
	}

	// button for going to Accelerometer page
	public void addListenerOnButton14() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		accButton = (Button) findViewById(R.id.button14);
 
		// acc activity
		accButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
}
