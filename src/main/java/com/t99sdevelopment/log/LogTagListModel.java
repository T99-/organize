package com.t99sdevelopment.log;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 6:23 PM - June 02, 2017.

import java.util.HashSet;

public class LogTagListModel extends HashSet<LogTag> {
	
	public void addTag(LogTag tag) {
		
		this.add(tag);
		
	}
	
	public void removeTag(LogTag tag) {
		
		if (this.contains(tag)) {
		
			this.remove(tag);
		
		}
		
	}
	
	public boolean checkTag(LogTag tag) {
		
		if (this.contains(tag)) {
			
			return true;
			
		} else {
		
			return false;
		
		}
		
	}
	
}