package com.example.turtlebotproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	//Intent intent = new Intent(context, anotherActivity.class);
    	//startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
//        addListenerOnButton2();
    }
    
    public void addListenerOnButton() {
    	 
		final Context context = this;
 
		Button button = (Button) findViewById(R.id.button1);
 
		button.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, MainActivity2.class);
                            startActivity(intent);   
 
			}
 
		});
    }
    
//    public void addListenerOnButton2() {
//      	 
//		final Context context = this;
// 
//		Button button = (Button) findViewById(R.id.button2);
// 
//		button.setOnClickListener(new OnClickListener() {
// 
//			public void onClick(View arg0) {
// 
//			    Intent intent = new Intent(context, MainActivity2.class);
//                            startActivity(intent);   
// 
//			}
// 
//		});
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
