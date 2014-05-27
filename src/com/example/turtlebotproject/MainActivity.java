package com.example.turtlebotproject;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends Activity {
	
	Button scanButton;
	
	private static final int REQUEST_ENABLE_BT = 1;
	private static final int SELECT_DEVICE     = 2;
	private static final int SCAN_FOR_DEVICE   = 3;
	
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
    	String device = "";
    	if(data == null)
    		return;
    	switch(requestCode)
    	{
    	case REQUEST_ENABLE_BT:
    		if(resultCode == RESULT_OK)
    			//if the user selected to enable BT then we go to the following method
    			handleBTConnection();
    		break;
    	case SELECT_DEVICE:
    		device = data.getStringExtra(BTDevicesView.RESULT);
    		handleBTConnection2(device);
    		break;
    	case SCAN_FOR_DEVICE:
    		device = data.getStringExtra(BTDevicesScanActivity.RESULT);
    		handleBTConnection2(device);
    		break;
    	default:
    		return;
    	}
    }
    
    //this method is here to reconnect the two separate paths execution can take
    private void handleBTConnection()
    {
    	
    //show the user a list of the already paired devices
    	Intent bt_intent = new Intent(this, BTDevicesView.class);
    	startActivityForResult(bt_intent, SELECT_DEVICE);
    	//from here it's back to onActivityResult() then to part 2
    }

    private void handleBTConnection2(String device)
    {
    	if(device.compareTo("") == 0)
    	{
    		Intent scan_intent = new Intent(this, BTDevicesScanActivity.class);
    		startActivityForResult(scan_intent, SCAN_FOR_DEVICE);
    	}
    	else
    	{
    		//we have a device mac address now we need to make sure it is available
    		BluetoothAdapter bt_adapter = BluetoothAdapter.getDefaultAdapter();
    		String mac = device.split("\n")[1]; //get the mac address from the string returned
    		BluetoothDevice bt_device = bt_adapter.getRemoteDevice(mac);
    		if(bt_device == null)
    			return;
    		//Method m = bt_device.getClass().getMethod("createRfcommSocket", new Class[] { int.class });
    		//BluetoothSocket connection = (BluetoothSocket)m.invoke(bt_device, port);
    		TurtleBotController.connect(bt_device);
    		if(TurtleBotController.isConnected())
    		{
    			//we now have the turtlebot connected so we can hand over to the 
    			//robot control interface
    			Intent intent = new Intent(this, MainActivity2.class);
    	        startActivity(intent); 
    		}
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
