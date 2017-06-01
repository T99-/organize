package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 8:10 AM - March 14th, 2017.

import com.t99sdevelopment.log.LogTimestamp;

import org.joda.time.DateTime;

public class DateHandler {

	public static String getTime() {
		
		DateTime time = new DateTime();
		int preHour = time.getHourOfDay();
		int hour;
		String AMPM;
		
		if (preHour < 13) {
			
			hour = preHour;
			AMPM = "AM";
			
		} else if (preHour >= 13) {
			
			hour = preHour - 12;
			AMPM = "PM";
			
		} else {
			
			hour = 0;
			AMPM = "ERR";
			
		}
		
		return String.format("%02d:%02d:%02d %s", hour, time.getMinuteOfHour(), time.getSecondOfMinute(), AMPM);

	}
	
	public static int getCurrentHourOfDay() {
		
		int hour = new DateTime().getHourOfDay();
		
		if (hour < 13) {
			
			return hour;
			
		} else if (hour >= 13) {
			
			return hour - 12;
			
		} else {
			
			try {
				
				// Yes, I know that I could just make the above an if-else instead of an if-elseif and avoid needing this.
				throw new Exception("Somehow there exists a value x such that x is not greater than or equal to 13, and that is also not less than 13. Apparently.");
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			return 0;
			
		}
		
	}
	
	public static int getCurrentMinuteOfHour() {
		
		return new DateTime().getMinuteOfHour();
		
	}
	
	public static int getCurrentSecondOfMinute() {
		
		return new DateTime().getSecondOfMinute();
		
	}
	
	public static int getCurrentHalfOfDay() {
		
		int hour = new DateTime().getHourOfDay();
		
		if (hour < 13) {
			
			return LogTimestamp.AM;
			
		} else if (hour >= 13) {
			
			return LogTimestamp.PM;
			
		} else {
			
			try {
				
				// Yes, I know that I could just make the above an if-else instead of an if-elseif and avoid needing this.
				throw new Exception("Somehow there exists a value x such that x is not greater than or equal to 13, and that is also not less than 13. Apparently.");
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			return 2;
			
		}
		
	}
	
	public static String getCurrentHalfOfDayString() {
		
		int hour = new DateTime().getHourOfDay();
		
		if (hour < 13) {
			
			return LogTimestamp.AM_STRINGVERSION;
			
		} else if (hour >= 13) {
			
			return LogTimestamp.PM_STRINGVERSION;
			
		} else {
			
			try {
				
				// Yes, I know that I could just make the above an if-else instead of an if-elseif and avoid needing this.
				throw new Exception("Somehow there exists a value x such that x is not greater than or equal to 13, and that is also not less than 13. Apparently.");
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			return "shits broke yo";
			
		}
		
	}
	
}