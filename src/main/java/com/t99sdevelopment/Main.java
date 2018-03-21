package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:40 AM - March 14th, 2017.

import com.t99sdevelopment.gui.Window;

/**
 * The main, originally executed class of the program.
 *
 * This class creates a static instance of the {@link com.t99sdevelopment.gui.Window} class that will be used throughout the program.
 *
 * @author Trevor Sears
 * @version v0.4.0
 * @since 5/14/17
 * @see com.t99sdevelopment.gui.Window
 *
 */
public class Main {
	
	public static Window mainWindow = new Window();
	
	public static void main(String[] args) {
		
		mainWindow.createWindow();
		
	}

}
