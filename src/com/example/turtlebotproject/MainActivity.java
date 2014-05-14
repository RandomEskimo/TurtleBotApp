package com.example.turtlebotproject;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends Activity {
	
	Button scanButton;
	
	private static final int REQUEST_ENABLE_BT = 1;
	private static final int SELECT_DEVICE     = 2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	//Intent intent = new Intent(context, anotherActivity.class);
    	//startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    
    public void addListenerOnButton() {
    	 
		final Context context = this;
 
		scanButton = (Button) findViewById(R.id.button1);
 
		scanButton.setOnClickListener(new OnClickListener() {
 
			public void onClick(View arg0) {
 
			    //Intent intent = new Intent(context, MainActivity2.class);
                //            startActivity(intent);
				
				//get the bluetooth adapter
				BluetoothAdapter bt_adapter = BluetoothAdapter.getDefaultAdapter();
				if(bt_adapter == null)
				{
					//add an error message here because this means the device does not support bluetooth
					Intent intent = new Intent(context, MainActivity2.class);
			        startActivity(intent);
					return;
				}
				//make sure bt is enabled
				if(!bt_adapter.isEnabled())
				{
					//if it isn't then ask the user to enable it
					Intent enable_bt_intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivityForResult(enable_bt_intent, REQUEST_ENABLE_BT);
					//from here we pick up at onActivityResult() below
				}
				else
				{
					//if bluetooth is enabled move directly to the following method
					handleBTConnection();
				}
				
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	switch(requestCode)
    	{
    	case REQUEST_ENABLE_BT:
    		if(resultCode == RESULT_OK)
    			//if the user selected to enable BT then we go to the following method
    			handleBTConnection();
    		break;
    	case SELECT_DEVICE:
    		String device = data.getStringExtra(BTDevicesView.RESULT);
    		handleBTConnection2(device);
    		break;
    	}
    }
    
    //this method is here to reconnect the two separate paths execution can take
    private void handleBTConnection()
    {
    	BluetoothAdapter bt_adapter = BluetoothAdapter.getDefaultAdapter();
    	
    //show the user a list of the already paired devices
    		Intent bt_intent = new Intent(this, BTDevicesView.class);
    		startActivityForResult(bt_intent, SELECT_DEVICE);
    		//from here it's back to onActivityResult() then to part 2
    		//handleBTConnection2(null);
    }

    private void handleBTConnection2(String device)
    {
    	if(device.compareTo("") == 0)
    	{
    		//this means we have to find a device by discovery
    	}
    	else
    	{
    		//we have a device mac address now we need to make sure it is available
    	}
    	Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent); 
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}

//class BTDeviceAdapter extends ArrayAdapter<BluetoothDevice>
//{
//	public BTDeviceAdapter(Context context, int textViewResourceId,
//	        List<BluetoothDevice> objects) 
//	{
//	    super(context, textViewResourceId, objects);
//	    for (int i = 0; i < objects.size(); ++i) 
//	    {
//	    	//mIdMap.put(objects.get(i), i);
//	    }
//	}
//}
