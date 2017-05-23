package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:40AM - March 14th, 2017.

public class Main {
	
	public static final Window mainWindow = new Window();

	public static void main(String[] args){
		
		mainWindow.showWindow();

		Thread windowTime = new Thread(mainWindow);
		
		windowTime.start();

	}

}