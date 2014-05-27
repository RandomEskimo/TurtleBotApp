package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class banjoActivity extends MainActivity	{

	Button startButton;
	Button stopButton;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banjo);
		addListenerOnStartButton();
		addListenerOnStopButton();
	}
	
	
	// button for starting script
	public void addListenerOnStartButton() {
	   	 
		final Context context = this;
 
		// assign buttons to xml button ids
		startButton = (Button) findViewById(R.id.button1);

		// joystick activity
		startButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
 
				TurtleBotController.startScript(TurtleBotController.SCRIPT_BANJO);
				
			}
		});
	}
	
	// button for stopping script
	public void addListenerOnStopButton() {
	   	 
		final Context context = this;
 
		// assign buttons to xml button ids
		stopButton = (Button) findViewById(R.id.button2);
 
		//scripts activity
		stopButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
				
				TurtleBotController.stop();
				
			}
		});
	}
}