package com.example.turtlebotproject;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

public class TurtleBotController {

	private static TurtleBotController tbc;
	
	public static final int SCRIPT_COVER      = 0;
	public static final int SCRIPT_COVER_DOCK = 1;
	public static final int SCRIPT_SPOT_COVER = 2;
	public static final int SCRIPT_MOUSE      = 3;
	public static final int SCRIPT_FIGURE_8   = 4;
	public static final int SCRIPT_WIMP       = 5;
	public static final int SCRIPT_HOME       = 6;
	public static final int SCRIPT_TAG        = 7;
	public static final int SCRIPT_PACHELBEL  = 8;
	public static final int SCRIPT_BANJO      = 9;
	
	public static final int ABORT_SCRIPT	  = -1;
	
	public static final int MAX_FORWARD       = 500;
	public static final int MAX_BACKWARD      = -500;
	
	private static final byte[] SAFE_START = {(byte)128, (byte)131};
	private static final byte[] DRIVE_FWD = {(byte)137, 0, 100, (byte)128, 0};
	private static final byte[] START = {(byte)128};
	private static final byte[] FULL = {(byte)132};
	private static final byte[] SAFE = {(byte)131};
	
	private static final byte DEMO = (byte)136;
	
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
		if(isConnected())
		{
			OutputStream out;
			try {
				out = tbc.socket.getOutputStream();
				out.write(com);
				System.out.println("Sent");
			} catch (IOException e) {
				System.out.println("Unable to send command");
			}
			
		}
		else
		{
			System.out.println("Not connected");
		}
	}
	
	//public void move
	
	public static void drive(int speed, int radius)
	{
		//System.out.println("Moving at: " + speed + ", radius: " + radius);
		if(exists())
		{
			byte[] bytes = {};//...
		}
	}
	
	public static void sendRaw(byte[] bytes)
	{
		if(exists())
			tbc.sendCommand(bytes);
	}
	
	public static void startScript(int script)
	{
		System.out.println("Starting script: " + script);
		
		byte[] bytes = {DEMO, (byte)script};
		if(exists())
		{
			tbc.sendCommand(SAFE_START);
			tbc.sendCommand(bytes);
		}
	}
	
	public static void stop()
	{
		if(exists())
			tbc.sendCommand(SAFE);
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
