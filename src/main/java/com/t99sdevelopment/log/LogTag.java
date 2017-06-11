package com.t99sdevelopment.log;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 2:55 PM - May 30, 2017.

import java.awt.*;

public class LogTag {

	private String name;
	private Color color;
	
	public LogTag(String name) {
	
		this.name = name;
		color = new Color(255, 255, 255);
	
	}
	
	public LogTag(String name, Color color) {
	
	
		this.name = name;
		this.color = color;
	
	}
	
	@Override
	public String toString() {
		
		return name;
		
	}
	
	public String getName() {
		
		return this.toString();
		
	}
	
	public void setName(String name) {
	
		this.name = name;
	
	}
	
	public Color getColor() {
	
		return color;
	
	}
	
	public void setColor(Color color) {
	
		this.color = color;
	
	}
	
}