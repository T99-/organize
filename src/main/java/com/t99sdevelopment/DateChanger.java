package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 8:10AM - March 14th, 2017.

import org.joda.time.DateTime;

public class DateChanger{

	public static String getTime(){

		return timeFinder();

	}

	private static String timeFinder() {

		DateTime timeObject = new DateTime();
		int preHour = timeObject.getHourOfDay();
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

		return String.format("%02d:%02d:%02d %s", hour, timeObject.getMinuteOfHour(), timeObject.getSecondOfMinute(), AMPM);

	}

}