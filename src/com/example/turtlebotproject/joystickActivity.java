package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.example.turtlebotproject.JoystickMovedListener;
import com.example.turtlebotproject.JoystickView;

public class joystickActivity extends MainActivity {
	
	// create page buttons
	Button joyButton;
	Button scriptButton;
	Button accButton;
	
	// create radio buttons
	// not implemented yet
	
	//joystick variables
	TextView txtX, txtY;
	JoystickView joystick;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joystick);
		
		// setup page button listeners
		addListenerOnButton();
		addListenerOnButton2();
		addListenerOnButton3();
		
		// create radio button listeners
		// not implemented yet
		
		// joystick variables
		// variables show x and y joystick movement
		txtX = (TextView)findViewById(R.id.textView2);
		txtY = (TextView)findViewById(R.id.textView3);
		// joystick view
		joystick = (JoystickView)findViewById(R.id.joystickView);
		// joystick listener
		joystick.setOnJostickMovedListener(_listener);
	}

// BUTTONS FOR LINKING TO SCREENS
	// button for going to Joystick page
	public void addListenerOnButton() {
	   	 
		final Context context = this;
 
		// assign buttons to xml button ids
		joyButton = (Button) findViewById(R.id.button1);

		// joystick activity
		joyButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, joystickActivity.class);
                            startActivity(intent);   
			}
		});
	}
	// button for going to Scripts page
	public void addListenerOnButton2() {
	   	 
		final Context context = this;
 
		// assign buttons to xml button ids
		scriptButton = (Button) findViewById(R.id.button2);
 
		//scripts activity
		scriptButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
	 
			    Intent intent = new Intent(context, scriptsActivity.class);
                startActivity(intent);   
	 
			}
		});
	}
	// button for going to Accelerometer page
	public void addListenerOnButton3() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		accButton = (Button) findViewById(R.id.button3);
 
		// acc activity
		accButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	
	//joystick method creates the listener, and sets the value of the orientation to the screen
    private JoystickMovedListener _listener = new JoystickMovedListener() {

    @Override
    public void OnMoved(int pan, int tilt) {
    	txtX.setText(Integer.toString(pan));
    	txtY.setText(Integer.toString(tilt));
    	
    	int factor = 50;
    	
    	int x = pan * factor;
    	int y = -tilt * factor;
    	
    	
    	//System.out.println("" + x + ", " + y);
    	TurtleBotController.driveXY(x, y);
    }

    @Override
    public void OnReleased() {
		txtX.setText("Stopped");
		txtY.setText("Stopped");
		TurtleBotController.drive(0, 0);
	}
    }; 
}
