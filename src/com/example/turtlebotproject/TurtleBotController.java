package com.example.turtlebotproject;

public class TurtleBotController {

	private static TurtleBotController tbc;
	
	private TurtleBotController(){}
	
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
	
	public static TurtleBotController getInstance()
	{
		if(tbc == null)
			tbc = new TurtleBotController();
		return tbc;
	}
	
	public void move
	
	public void drive(int speed, int radius)
	{
		System.out.println("Movinf at: " + speed + ", radius: " + radius);
	}
	
	public void startScript(int script)
	{
		System.out.println("Starting script: " + script);
	}
	
	public void stopScript()
	{
		System.out.println("Script stopped");
	}
}
