package com.example.turtlebotproject;

import java.util.ArrayList;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;



public class BTDevicesScanActivity extends ListActivity {

	ListView found_devices;
	Button   cancel_button;
	
	ArrayAdapter<String> devices;
	
	public static final String RESULT = "result";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_btdevices_scan);
		
		found_devices = (ListView)findViewById(android.R.id.list);
		found_devices.setOnItemClickListener(item_click_listener);
		
		cancel_button = (Button)findViewById(R.id.button1);
		cancel_button.setOnClickListener(cancel_click_listener);
		
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		registerReceiver(mReceiver, filter);
		
		devices = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
		found_devices.setAdapter(devices);
		
		BluetoothAdapter bt_adapter = BluetoothAdapter.getDefaultAdapter();
		if(!bt_adapter.startDiscovery())
			System.out.println("Discovery failed");
	}
	
	@Override
	protected void onDestroy()
	{
		this.unregisterReceiver(mReceiver);
	}
	
	private OnClickListener cancel_click_listener = new OnClickListener() {
		 
		public void onClick(View arg0) {
			Intent data = new Intent();
			data.putExtra(RESULT, "");
			setResult(RESULT_OK, data);
			BluetoothAdapter bt_adapter = BluetoothAdapter.getDefaultAdapter();
			bt_adapter.cancelDiscovery(); //end device discovery
			finish();
		}
	};
	
	private OnItemClickListener item_click_listener = new OnItemClickListener()
	{
		public void onItemClick(AdapterView parent, View v, int position, long id)
		{
			String device = devices.getItem(position);
			if(device == null)
			{
				System.out.println("device is null");
				device = "";
			}
			Intent data = new Intent();
			data.putExtra(RESULT, device);
			setResult(RESULT_OK, data);
			BluetoothAdapter bt_adapter = BluetoothAdapter.getDefaultAdapter();
			bt_adapter.cancelDiscovery(); //end device discovery
			finish();
		}
	};
	
	// Create a BroadcastReceiver for ACTION_FOUND
	private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
	    public void onReceive(Context context, Intent intent) {
	        String action = intent.getAction();
	        // When discovery finds a device
	        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
	            // Get the BluetoothDevice object from the Intent
	            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	            // Add the name and address to an array adapter to show in a ListView
	            devices.add(device.getName() + "\n" + device.getAddress());
	            System.out.println(device.getName() + ": " + device.getAddress());
	        }
	    }
	};

	
}
