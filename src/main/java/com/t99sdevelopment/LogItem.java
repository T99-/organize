package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:25 AM - March 25, 2017

import java.util.Formatter;
import org.apache.commons.lang3.StringUtils;

public class LogItem{
	
	public static final int AM = 0;
	public static final int PM = 1;
	public static final String AM_STRINGVERSION = "AM";
	public static final String PM_STRINGVERSION = "PM";
	
	private int hour;
	private int minute;
	private int second;
	private int halfOfDay;
	private String event;
	
	public LogItem(){
		
		this(
				Integer.parseInt(DateChanger.getTime().substring(0, StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 1))),
				Integer.parseInt(DateChanger.getTime().substring(StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 1) + 1, StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 2))),
				Integer.parseInt(DateChanger.getTime().substring(StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 2) + 1, DateChanger.getTime().indexOf(" "))),
				DateChanger.getTime().substring(DateChanger.getTime().length() - 2, DateChanger.getTime().length() - 1).toUpperCase() == AM_STRINGVERSION ? AM : PM,
				""
				//TODO - make sure that values other than 'AM' and 'PM' can't be passed as valid arguments to the constructors.
		);
		
	}
	
	public LogItem(String event){
		
		this(
				Integer.parseInt(DateChanger.getTime().substring(0, StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 1))),
				Integer.parseInt(DateChanger.getTime().substring(StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 1) + 1, StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 2))),
				Integer.parseInt(DateChanger.getTime().substring(StringUtils.ordinalIndexOf(DateChanger.getTime(), ":", 2) + 1, DateChanger.getTime().indexOf(" "))),
				DateChanger.getTime().substring(DateChanger.getTime().length() - 2, DateChanger.getTime().length() - 1).toUpperCase() == AM_STRINGVERSION ? AM : PM,
				event
		);
		
	}
	
	public LogItem(String event, String time){
		
		this(
				Integer.parseInt(time.substring(0, StringUtils.ordinalIndexOf(time, ":", 1))),
				Integer.parseInt(time.substring(StringUtils.ordinalIndexOf(time, ":", 1) + 1, StringUtils.ordinalIndexOf(time, ":", 2))),
				Integer.parseInt(time.substring(StringUtils.ordinalIndexOf(time, ":", 2) + 1, time.indexOf(" "))),
				time.substring(time.length() - 2, time.length() - 1).toUpperCase() == AM_STRINGVERSION ? AM : PM,
				event
		);
		
	}
	
	public LogItem(int hour, int minute, int second, int halfOfDay, String event){
	
		if(!isBadFormat(hour, minute, second, halfOfDay)){
			
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			this.halfOfDay = halfOfDay;
			this.event = event;
			
		} else {
			
			this.hour = 0;
			this.minute = 0;
			this.second = 0;
			this.halfOfDay = 0;
			this.event = null;
			
		}
	
	}
	
	public int getHour(){
		
		return hour;
		
	}
	
	public int getMinute(){
		
		return minute;
		
	}
	
	public int getSecond(){
		
		return second;
		
	}
	
	public int getHalfOfDay(){
		
		return halfOfDay;
		
	}
	
	public String getEvent(){
		
		return event;
		
	}
	
	public void setTime(String time){
		
		setTime(
				Integer.parseInt(time.substring(0, StringUtils.ordinalIndexOf(time, ":", 1))),
				Integer.parseInt(time.substring(StringUtils.ordinalIndexOf(time, ":", 1) + 1, StringUtils.ordinalIndexOf(time, ":", 2))),
				Integer.parseInt(time.substring(StringUtils.ordinalIndexOf(time, ":", 2) + 1, time.indexOf(" "))),
				time.substring(time.length() - 2, time.length() - 1).toUpperCase() == AM_STRINGVERSION ? AM : PM
		);
		
	}
	
	public void setTime(int hour, int minute, int second, int halfOfDay){
		
		if(!isBadFormat(hour, minute, second, halfOfDay)){
			
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			this.halfOfDay = halfOfDay;
			this.event = event;
			
		} else {
			
			this.hour = 0;
			this.minute = 0;
			this.second = 0;
			this.halfOfDay = 0;
			this.event = null;
			
		}
		
	}
	
	public void setHour(int hour){
		
		if(hour < 13){
			
			this.hour = hour;
			this.halfOfDay = AM;
			
		} else if(hour > 12) {
			
			this.hour = hour - 12;
			this.halfOfDay = PM;
			
		}
		
	}
	
	public void setMinute(int minute){
		
		this.minute = minute;
		
	}
	
	public void setSecond(int second){
		
		this.second = second;
		
	}
	
	public String setHalfOfDay(int halfOfDay){
		
		this.halfOfDay = halfOfDay;
		
		String returned;
		
		if(halfOfDay == AM){
			
			return AM_STRINGVERSION;
			
		} else if(halfOfDay == PM) {
			
			return PM_STRINGVERSION;
			
		} else {
			
			return null;
			
		}
		
	}
	
	public String setHalfOfDay(String halfOfDay){
		
		if(halfOfDay == AM_STRINGVERSION){
			
			this.halfOfDay = AM;
			return AM_STRINGVERSION;
			
		} else if(halfOfDay == PM_STRINGVERSION) {
			
			this.halfOfDay = PM;
			return PM_STRINGVERSION;
			
		} else {
			
			throw new IllegalArgumentException("com.t99sdevelopment.LogItem was passed a String argument that did not match that values of either com.t99sdevelopment.LogItem.AM_STRINGVERSION (which evaluates to 'AM') or com.t99sdevelopment.LogItem.PM_STRINGVERSION (which evaluates to 'PM')");
			
		}
		
	}
	
	public void setEvent(String event){
		
		this.event = event;
		
	}
	
	public int incrementHour(){
		
		this.hour++;
		return this.hour;
		
	}
	
	public int decrementHour(){
		
		this.hour--;
		return this.hour;
		
	}
	
	public int incrementMinute(){
		
		this.minute++;
		return this.minute;
		
	}
	
	public int decrementMinute(){
		
		this.minute--;
		return this.minute;
		
	}
	
	public int incrementSecond(){
		
		this.second++;
		return this.second;
		
	}
	
	public int decrementSecond(){
		
		this.second--;
		return this.second;
		
	}
	
	public String changeHalfOfDay(){
		
		if(this.halfOfDay == AM){
			
			this.halfOfDay = PM;
			
		} else if(this.halfOfDay == PM) {
			
			this.halfOfDay = AM;
			
		}
		
		if(halfOfDay == AM){
			
			return AM_STRINGVERSION;
			
		} else if(halfOfDay == PM) {
			
			return PM_STRINGVERSION;
			
		} else {
			
			return null;
			
		}
		
	}
	
	public String getTimestamp(){
		
		Formatter formatter = new Formatter();
		
		String timestamp;
		
		String hour_String;
		String minute_String;
		String second_String;
		String halfOfDay_String = getStringversionOfHalfOfDay(this.halfOfDay);
		
		if(Integer.toString(this.hour).length() < 2){
			
			hour_String = "0" + Integer.toString(this.hour);
			
		} else if(Integer.toString(this.hour).length() == 2) {
			
			hour_String = Integer.toString(this.hour);
			
		} else {
			
			hour_String = "err";
			
		}
		
		if(Integer.toString(this.minute).length() < 2){
			
			minute_String = "0" + Integer.toString(this.minute);
			
		} else if(Integer.toString(this.minute).length() == 2) {
			
			minute_String = Integer.toString(this.minute);
			
		} else {
			
			minute_String = "err";
			
		}
		
		if(Integer.toString(this.second).length() < 2){
			
			second_String = "0" + Integer.toString(this.second);
			
		} else if(Integer.toString(this.second).length() == 2) {
			
			second_String = Integer.toString(this.second);
			
		} else {
			
			second_String = "err";
			
		}
		
		timestamp = hour_String + ":" + minute_String + ":" + second_String + " " + halfOfDay_String;
		
		return timestamp;
		
	}
	
	public void clearEvent(){
		
		this.event = "";
		
	}
	
	public String getStringversionOfHalfOfDay(int halfOfDay){
		
		if(halfOfDay == AM){
			
			return AM_STRINGVERSION;
			
		} else if(halfOfDay == PM) {
			
			return PM_STRINGVERSION;
			
		} else {
			
			return null;
			
		}
		
	}
	
	private boolean isBadFormat(int hour, int minute, int second, int halfOfDay){
		
		boolean somethingBadQuestionMark = false;
		
		if(hour < 0 || hour >= 60){
			
			somethingBadQuestionMark = true;
			
			//System.err.println("com.t99sdevelopment.LogItem was passed an argument for 'int hour' parameter that did not fall within the real range 0<hour<=12");
			throw new IllegalArgumentException("com.t99sdevelopment.LogItem was passed an argument for 'int hour' parameter that did not fall within the real range 0<hour<=12");
			
		}
		
		if(minute < 0 || minute >= 60){
			
			somethingBadQuestionMark = true;
			
			//System.err.println("com.t99sdevelopment.LogItem was passed an argument for 'int minute' parameter that did not fall within the real range 0<=minute<60");
			throw new IllegalArgumentException("com.t99sdevelopment.LogItem was passed an argument for 'int minute' parameter that did not fall within the real range 0<=minute<60");
			
		}
		
		if(second < 0 || second >= 60){
			
			somethingBadQuestionMark = true;
			
			//System.err.println("com.t99sdevelopment.LogItem was passed an argument for 'int second' parameter that did not fall within the real range 0<=second<60");
			throw new IllegalArgumentException("com.t99sdevelopment.LogItem was passed an argument for 'int second' parameter that did not fall within the real range 0<=second<60");
			
		}
		
		if(halfOfDay != AM && halfOfDay != PM){
			
			somethingBadQuestionMark = true;
			
			//System.err.println("com.t99sdevelopment.LogItem was passed an argument for 'int halfOfDay' parameter that did not correspond to com.t99sdevelopment.LogItem.AM (which evaluates to 0) or to com.t99sdevelopment.LogItem.PM (which evaluates to 1)");
			throw new IllegalArgumentException("com.t99sdevelopment.LogItem was passed an argument for 'int halfOfDay' parameter that did not correspond to com.t99sdevelopment.LogItem.AM (which evaluates to 0) or to com.t99sdevelopment.LogItem.PM (which evaluates to 1)");
			
		}
		
		return somethingBadQuestionMark;
		
	}
}