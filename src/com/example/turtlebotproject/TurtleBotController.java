package com.example.turtlebotproject;

public class TurtleBotController {

	private static TurtleBotController tbc;
	
	private TurtleBotController(){}
	
	public static final int COVER      = 0;
	public static final int SPOT_COVER = 1;
	public static final int FIGURE_8   = 2;
	public static final int HOME       = 3;
	public static final int PACHELBEL  = 4;
	public static final int COVER_DOCK = 5;
	public static final int MOUSE      = 6;
	public static final int WIMP       = 7;
	public static final int TAG        = 8;
	public static final int BANJO      = 9;
	
	public static TurtleBotController getInstance()
	{
		if(tbc == null)
			tbc = new TurtleBotController();
		return tbc;
	}
	
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
