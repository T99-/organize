package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:40 AM - March 14th, 2017.

import com.t99sdevelopment.gui.Window;
import com.t99sdevelopment.listen.EventLogListener;
import com.t99sdevelopment.listen.LogEditorListener;
import com.t99sdevelopment.listen.ShutdownListener;

public class Main {
	
	public static final boolean DEBUG = true;
	
	public static final Window mainWindow = new Window();
	
	public static final EventLogListener eventLogActionListener = new EventLogListener();
	public static final LogEditorListener logEditorActionListener = new LogEditorListener();
	public static final ShutdownListener shutdownActionListener = new ShutdownListener(0);

	public static void main(String[] args){
		
		mainWindow.showWindow();

		Thread windowTime = new Thread(mainWindow);
		
		windowTime.start();

	}

}