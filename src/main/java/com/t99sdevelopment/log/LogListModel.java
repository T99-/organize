package com.t99sdevelopment.log;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 9:26 PM - March 25th, 2017.

import javax.swing.*;

public class LogListModel extends DefaultListModel<LogItem> {
	
	public void addElement(LogItem logItem) {
		
		super.addElement(logItem);
		
	}
	
	public String getTimestampAt(int index) {
		
		return elementAt(index).getTimestamp().toString();
		
	}
	
	public String getEventAt(int index) {
		
		return elementAt(index).getEvent();
		
	}
	
}