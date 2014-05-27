package com.example.turtlebotproject;

import java.io.IOException;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

public class TurtleBotController {

	private static TurtleBotController tbc;
	
	public static final int SCRIPT_COVER      = 0;
	public static final int SCRIPT_SPOT_COVER = 1;
	public static final int SCRIPT_FIGURE_8   = 2;
	public static final int SCRIPT_HOME       = 3;
	public static final int SCRIPT_PACHELBEL  = 4;
	public static final int SCRIPT_COVER_DOCK = 5;
	public static final int SCRIPT_MOUSE      = 6;
	public static final int SCRIPT_WIMP       = 7;
	public static final int SCRIPT_TAG        = 8;
	public static final int SCRIPT_BANJO      = 9;
	
	public static final int MAX_FORWARD       = 500;
	public static final int MAX_BACKWARD      = -500;
	
	private static final UUID T_BOT_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
	
	private final BluetoothSocket socket;
	private final BluetoothDevice device;
	
	private TurtleBotController(BluetoothDevice device)
	{
		this.device = device;
		BluetoothSocket tmp = null;
		
		try {
            tmp = device.createRfcommSocketToServiceRecord(T_BOT_UUID);
        } catch (IOException e) { 
        }
        this.socket = tmp;
        
        try {
            // Connect the device through the socket. This will block
            // until it succeeds or throws an exception
            socket.connect();
            System.out.println("Socket connected successfully");
        } catch (IOException connectException) {
            // Unable to connect; close the socket and get out
            try {
                socket.close();
                System.out.println("Connection failed");
            } catch (IOException closeException) { }
        }

	}
	
	public static void connect(BluetoothDevice device)
	{
		tbc = new TurtleBotController(device);
	}
	
	public static boolean isConnected()
	{
		if(exists())
		{
			if(tbc.socket == null)
				return false;
			return tbc.socket.isConnected();
		}
		return false;
	}
	
	private static boolean exists()
	{
		if(tbc == null)
			return false;
		return true;
	}
	
	private void sendCommand(byte[] com)
	{
		
	}
	
	//public void move
	
	public static void drive(int speed, int radius)
	{
		System.out.println("Moving at: " + speed + ", radius: " + radius);
	}
	
	public static void startScript(int script)
	{
		System.out.println("Starting script: " + script);
	}
	
	public static void stop()
	{
		System.out.println("Turtlebot stopped");
	}
	
	public static void close()
	{
		if(exists())
		{
			if(tbc.socket == null)
				return;
			try {
				tbc.socket.close();
			} catch (IOException e) {}
		}
	}
}
