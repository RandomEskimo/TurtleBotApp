package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.turtlebotproject.JoystickMovedListener;
import com.example.turtlebotproject.JoystickView;

public class joystickActivity extends MainActivity {
	
	// create page buttons
	Button joyButton;
	Button scriptButton;
	Button accButton;
	
	// create radio group
	RadioGroup velocityGroup;
	RadioButton fast;
	RadioButton medium;
	RadioButton slow;
	
	//joystick variables
	TextView txtX, txtY;
	JoystickView joystick;
	
	// speed factor for velocity of turtlebot
	int factor = 100;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joystick);
		
		// setup page button listeners
		addListenerOnButton();
		addListenerOnButton2();
		addListenerOnButton3();
		
		// setup velocity listener
		addRadioButtonListener1();
		addRadioButtonListener2();
		addRadioButtonListener3();
		
		// joystick variables
		// variables show x and y joystick movement
		txtX = (TextView)findViewById(R.id.textView2);
		txtY = (TextView)findViewById(R.id.textView3);
		// joystick view
		joystick = (JoystickView)findViewById(R.id.joystickView);
		// joystick listener
		joystick.setOnJostickMovedListener(_listener);
	}
	
	// method to set speed factor
	public void setFactor(int x)
	{
		this.factor=x;
	}
	
	// method to print factor
	public void printFactor()
	{
		System.out.println("" + this.factor + "");
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
    

	private void addRadioButtonListener1() {
		
		// get radio button ids
		fast = (RadioButton) findViewById(R.id.radio0);
		
		// setup listeners
		// fast radio button
		fast.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {		
				
				// set speed to fast 
				setFactor(100);
				printFactor();
				}

			}
		);
		System.out.println("" + factor + "");	
	}
	
	// medium velocity button listener
	private void addRadioButtonListener2() {
		
		// get radio button ids	
		medium = (RadioButton) findViewById(R.id.radio1);
		
		// setup listeners
		medium.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {		
				
					// set speed to medium 
					setFactor(50);
					printFactor();
				}
			}
		);
		System.out.println("" + factor + "");
	}
	
	// slow velocity button listener
	private void addRadioButtonListener3() {
	
		// get radio button ids
		slow = (RadioButton) findViewById(R.id.radio2);
		
		// fast radio button
		slow.setOnClickListener(new OnClickListener() {
	
			public void onClick(View arg0) {		
					
					// set speed to slow 
					setFactor(20);
					printFactor();
				}
			}
		);
		}
}