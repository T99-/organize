package com.t99sdevelopment.log;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:25 AM - March 25th, 2017.

public class LogItem {
	
	private static final String SPACE = " ";
	
	private String event;
	private String title;
	private String description;
	
	private LogTimestamp timestamp;
	private LogTagListModel tags = new LogTagListModel();
	
	public LogItem() {
		
		this("");
		
	}
	
	public LogItem(String event) {
		
		this.event = event;
		timestamp = new LogTimestamp();
		
	}
	
	public LogItem(String event, String time) {
		
		timestamp = new LogTimestamp(time);
		
		this.event = event;
		
	}
	
	public LogItem(String event, LogTimestamp timestamp) {
		
		this.timestamp = timestamp;
		
		this.event = event;
		
	}
	
	public LogItem(int hour, int minute, int second, int halfOfDay, String event) {
	
		timestamp = new LogTimestamp(hour, minute, second, halfOfDay);
		
		this.event = event;
	
	}
	
	public LogItem(int hour, int minute, int second, String halfOfDay, String event) {
		
		timestamp = new LogTimestamp(hour, minute, second, halfOfDay);
		
		this.event = event;
		
	}
	
	@Override
	public String toString() {
		
		return LogTimestamp.surroundWithSquareBrackets(timestamp.toString()) + SPACE + event;
		
	}
	
	public String getEvent() {
		
		return event;
		
	}
	
	public LogTimestamp getTimestamp() {
		
		return timestamp;
		
	}
	
	public void setEvent(String event) {
		
		this.event = event;
		
	}
	
	public void clearEvent() {
		
		this.event = "";
		
	}
	
}