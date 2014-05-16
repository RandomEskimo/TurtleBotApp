package com.example.turtlebotproject;

// interface that listens for joystick movement
public interface JoystickMovedListener {
	
	public void OnMoved(int pan, int tilt);
 	public void OnReleased();

}
