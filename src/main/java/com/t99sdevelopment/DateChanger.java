package com.t99sdevelopment;

import org.joda.time.DateTime;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 8:10AM - March 14th, 2017.

public class DateChanger{

    public static String getDate(){

        return dateFinder();

    }

    private static String dateFinder() {

        DateTime dateObject = new DateTime();
        int preHour = dateObject.getHourOfDay();
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

        return String.format("%02d:%02d:%02d %s", hour, dateObject.getMinuteOfHour(), dateObject.getSecondOfMinute(), AMPM);

    }

}
