package com.t99sdevelopment.log;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:26 PM - May 29th, 2017.

import com.t99sdevelopment.DateHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.InputMismatchException;

public class LogTimestamp {
	
	public static final int AM = 0;
	public static final int PM = 1;
	public static final String AM_STRINGVERSION = "AM";
	public static final String PM_STRINGVERSION = "PM";
	
	private int hour;
	private int minute;
	private int second;
	private int halfOfDay;
	
	public LogTimestamp() {
	
		hour = DateHandler.getCurrentHourOfDay();
		minute = DateHandler.getCurrentMinuteOfHour();
		second = DateHandler.getCurrentSecondOfMinute();
		halfOfDay = DateHandler.getCurrentHalfOfDay();
		
	}
	
	public LogTimestamp(int hour, int minute, int second, int halfOfDay) {
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.halfOfDay = halfOfDay;
		
	}
	
	public LogTimestamp(int hour, int minute, int second, String halfOfDay) {
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
		if (halfOfDay.equals(AM_STRINGVERSION)) {
			
			this.halfOfDay = AM;
			
		} else if (halfOfDay.equals(PM_STRINGVERSION)) {
			
			this.halfOfDay = PM;
			
		} else {
			
			throw new InputMismatchException("The given string did not correspond to a half of day. Please see com.t99sdevelopment.log.LogTimestamp for help.");
			
		}
		
	}
	
	public LogTimestamp(String time) {
		
		this.hour = parseHour(time);
		this.minute = parseMinute(time);
		this.second = parseSecond(time);
		this.halfOfDay = parseHalfOfDay(time);
		
	}
	
	@Override
	public String toString() {
		
		String timestamp;
		
		String hour_String;
		String minute_String;
		String second_String;
		String halfOfDay_String = getStringVersionOfHalfOfDay(this.halfOfDay);
		
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
	
	@Override
	public boolean equals(Object object) {
		
		LogTimestamp timestamp;
		
		if (object instanceof LogTimestamp) {
		
			timestamp = (LogTimestamp) object;
		
		} else {
			
			return false;
			
		}
		
		if (timestamp.hour == this.hour &&
			timestamp.minute == this.minute &&
			timestamp.second == this.second &&
			timestamp.halfOfDay == this.halfOfDay) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	@Override
	public int hashCode() {
		
		int result = hour;
		result = 31 * result + minute;
		result = 31 * result + second;
		result = 31 * result + halfOfDay;
		return result;
	}
	
	public String getStringVersionOfHalfOfDay(int halfOfDay) {
		
		if(halfOfDay == AM){
			
			return AM_STRINGVERSION;
			
		} else if(halfOfDay == PM) {
			
			return PM_STRINGVERSION;
			
		} else {
			
			return null;
			
		}
		
	}
	
	private boolean isBadFormat(int hour, int minute, int second, int halfOfDay) {
		
		boolean badFormat = false;
		
		if(hour < 0 || hour >= 60){
			
			badFormat = true;
			
			throw new IllegalArgumentException("com.t99sdevelopment.log.LogItem was passed an argument for 'int hour' parameter that did not fall within the real range 0<hour<=12");
			
		}
		
		if(minute < 0 || minute >= 60){
			
			badFormat = true;
			
			throw new IllegalArgumentException("com.t99sdevelopment.log.LogItem was passed an argument for 'int minute' parameter that did not fall within the real range 0<=minute<60");
			
		}
		
		if(second < 0 || second >= 60){
			
			badFormat = true;
			
			throw new IllegalArgumentException("com.t99sdevelopment.log.LogItem was passed an argument for 'int second' parameter that did not fall within the real range 0<=second<60");
			
		}
		
		if(halfOfDay != AM && halfOfDay != PM){
			
			badFormat = true;
			
			throw new IllegalArgumentException("com.t99sdevelopment.log.LogItem was passed an argument for 'int halfOfDay' parameter that did not correspond to com.t99sdevelopment.log.LogItem.AM (which evaluates to 0) or to com.t99sdevelopment.log.LogItem.PM (which evaluates to 1)");
			
		}
		
		return badFormat;
		
	}
	
	public static String surroundWithSquareBrackets(String text) {
		
		return "[" + text + "]";
		
	}
	
	public void setTime(int hour, int minute, int second, int halfOfDay) {
		
		if(!isBadFormat(hour, minute, second, halfOfDay)){
			
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			this.halfOfDay = halfOfDay;
			
		} else {
			
			this.hour = 0;
			this.minute = 0;
			this.second = 0;
			this.halfOfDay = 0;
			
		}
		
	}
	
	public void setTime(String time) {
		
		setTime(
				parseHour(time),
				parseMinute(time),
				parseSecond(time),
				parseHalfOfDay(time)
		);
		
	}
	
	public void setHour(int hour) {
		
		if(hour < 13){
			
			this.hour = hour;
			this.halfOfDay = AM;
			
		} else if(hour > 12) {
			
			this.hour = hour - 12;
			this.halfOfDay = PM;
			
		}
		
	}
	
	public void setMinute(int minute) {
		
		this.minute = minute;
		
	}
	
	public void setSecond(int second) {
		
		this.second = second;
		
	}
	
	public boolean setHalfOfDay(int halfOfDay) {
		
		if(halfOfDay == AM){
			
			this.halfOfDay = AM;
			return true;
			
		} else if(halfOfDay == PM) {
			
			this.halfOfDay = PM;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public boolean setHalfOfDay(String halfOfDay) {
		
		if(halfOfDay.equals(AM_STRINGVERSION)){
			
			this.halfOfDay = AM;
			return true;
			
		} else if(halfOfDay.equals(PM_STRINGVERSION)) {
			
			this.halfOfDay = PM;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public int incrementHour() {
		
		this.hour++;
		return this.hour;
		
	}
	
	public int decrementHour() {
		
		this.hour--;
		return this.hour;
		
	}
	
	public int incrementMinute() {
		
		this.minute++;
		return this.minute;
		
	}
	
	public int decrementMinute() {
		
		this.minute--;
		return this.minute;
		
	}
	
	public int incrementSecond() {
		
		this.second++;
		return this.second;
		
	}
	
	public int decrementSecond() {
		
		this.second--;
		return this.second;
		
	}
	
	public String changeHalfOfDay() {
		
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
	
	public int getHour() {
		
		return hour;
		
	}
	
	public int getMinute() {
		
		return minute;
		
	}
	
	public int getSecond() {
		
		return second;
		
	}
	
	public int getHalfOfDay() {
		
		return halfOfDay;
		
	}
	
	public static int parseHour(String time) {
		
		return Integer.parseInt(time.substring(0, StringUtils.ordinalIndexOf(time, ":", 1)));
		
	}
	
	public static int parseMinute(String time) {
		
		return Integer.parseInt(time.substring(StringUtils.ordinalIndexOf(time, ":", 1) + 1, StringUtils.ordinalIndexOf(time, ":", 2)));
		
	}
	
	public static int parseSecond(String time) {
		
		return Integer.parseInt(time.substring(StringUtils.ordinalIndexOf(time, ":", 2) + 1, time.indexOf(" ")));
		
	}
	
	public static int parseHalfOfDay(String time) {
		
		String halfOfDay = time.substring(time.length() - 2, time.length() - 1).toUpperCase();
		
		if(halfOfDay.equals(AM_STRINGVERSION)){
			
			return AM;
			
		} else if(halfOfDay.equals(PM_STRINGVERSION)) {
			
			return PM;
			
		} else {
			
			throw new IllegalArgumentException("com.t99sdevelopment.log.LogItem was passed a String argument that did not match that values of either com.t99sdevelopment.log.LogItem.AM_STRINGVERSION (which evaluates to 'AM') or com.t99sdevelopment.log.LogItem.PM_STRINGVERSION (which evaluates to 'PM')");
			
		}
		
	}
	
}