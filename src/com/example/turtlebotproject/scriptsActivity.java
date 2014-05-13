package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class scriptsActivity extends MainActivity {
	
	// create page buttons
	Button joyButton;
	Button scriptButton;
	Button accButton;
	
	// create script buttons
	Button script1;
	Button script2;
	Button script3;
	Button script4;
	Button script5;
	Button script6;
	Button script7;
	Button script8;
	Button script9;
	Button script10;
	Button stopScript;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scripts);
		
		// setup page button listeners
		addListenerOnButton12();
		addListenerOnButton13();
		addListenerOnButton14();
		
		//create script button listeners
		addListenerOnScript1();
		addListenerOnScript2();
		addListenerOnScript3();
		addListenerOnScript4();
		addListenerOnScript5();
		addListenerOnScript6();
		addListenerOnScript7();
		addListenerOnScript8();
		addListenerOnScript9();
		addListenerOnScript10();
		addListenerOnStopScript();
	}
	
// BUTTONS FOR LINKING TO SCREENS
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
	
//BUTTONS FOR SCRIPTS
	// script1 cover
	public void addListenerOnScript1() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script1 = (Button) findViewById(R.id.button1);
 
		script1.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
				
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script2 cover+dock
	public void addListenerOnScript2() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script2 = (Button) findViewById(R.id.button2);
 
		script2.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script3 spot cover
	public void addListenerOnScript3() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script3 = (Button) findViewById(R.id.button3);
 
		script3.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script4 mouse
	public void addListenerOnScript4() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script4 = (Button) findViewById(R.id.button4);
 
		script4.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script5 figure 8
	public void addListenerOnScript5() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script5 = (Button) findViewById(R.id.button5);
 
		script5.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script6 wimp
	public void addListenerOnScript6() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script6 = (Button) findViewById(R.id.button6);
 
		script6.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script7 home
	public void addListenerOnScript7() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script7 = (Button) findViewById(R.id.button7);
 
		script7.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script8 tag
	public void addListenerOnScript8() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script8 = (Button) findViewById(R.id.button8);
 
		script8.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script9 pachelbel
	public void addListenerOnScript9() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script9 = (Button) findViewById(R.id.button9);
 
		script9.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// script10 banjo
	public void addListenerOnScript10() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		script10 = (Button) findViewById(R.id.button10);
 
		script10.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
	// stop script (button 11)
	public void addListenerOnStopScript() {
	   	 
		final Context context = this;
		
		// assign buttons to xml button ids
		stopScript = (Button) findViewById(R.id.button11);
 
		stopScript.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
		
				// not implemented yet
				Intent intent = new Intent(context, accActivity.class);
				startActivity(intent);   
		
			}
		});
	}
}
