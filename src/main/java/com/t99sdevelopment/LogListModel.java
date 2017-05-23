package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 9:26 PM - March 25th, 2017

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

public class LogListModel extends DefaultListModel<String>{
	
	public void addElement(LogItem logItem){
		
		super.addElement("[" + logItem.getTimestamp() + "] " + logItem.getEvent());
		
	}
	
	public String getTimestamp(int index){
		
		String parsedElement = elementAt(index);
		
		return parsedElement.substring(0,14);
		
	}
	
	public String getEvent(int index){
		
		String parsedElement = elementAt(index);
		
		return parsedElement.substring(14);
		
	}
	
}