package com.example.turtlebotproject;

import java.util.ArrayList;
import java.util.Set;

import android.app.Activity;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class BTDevicesView extends ListActivity {

	ListView devices_list;
	Button cancel_button;
	ArrayAdapter<String> known_devices;
	
	public static final String RESULT = "result";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_btdevices_view);
		devices_list = (ListView) findViewById(android.R.id.list);
		devices_list.setOnItemClickListener(item_click_listener);
		
		cancel_button = (Button)findViewById(R.id.cancel_button);
		cancel_button.setOnClickListener(cancel_click_listener);
		
		BluetoothAdapter bt_adapter = BluetoothAdapter.getDefaultAdapter();
    	
    //show the user a list of the already paired devices
    	//first get a set of the devices
    	Set<BluetoothDevice> paired_devices = bt_adapter.getBondedDevices();
    	
    	if(paired_devices.size() > 0)
    	{
    		//add the devices to an array adapter
    		known_devices = new ArrayAdapter<String>(this, 
        			android.R.layout.simple_list_item_1, new ArrayList<String>());
    		for(BluetoothDevice device : paired_devices)
    			known_devices.add(device.getName() + "\n" + device.getAddress());
    		devices_list.setAdapter(known_devices);
    		
    		//startActivityForResult(bt_intent, SELECT_DEVICE);
    	}
	}
	
	private OnItemClickListener item_click_listener = new OnItemClickListener()
	{
		public void onItemClick(AdapterView parent, View v, int position, long id)
		{
			@SuppressWarnings("unchecked")
			//ArrayAdapter<String> devices = (ArrayAdapter<String>) getListAdapter();
			String device = known_devices.getItem(position);
			if(device == null)
			{
				System.out.println("device is null");
				device = "";
			}
			Intent data = new Intent();
			data.putExtra(RESULT, device);
			setResult(RESULT_OK, data);
			finish();
		}
	};
	
	private OnClickListener cancel_click_listener = new OnClickListener() {
		 
		public void onClick(View arg0) {
			Intent data = new Intent();
			data.putExtra(RESULT, "");
			setResult(RESULT_OK, data);
			finish();
		}
	};
}
