package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:42AM - March 21st, 2017.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventLogListener implements ActionListener{

    private String timestamp;

    public EventLogListener(String timeOnClick){

        timestamp = timeOnClick;

    }

    public void actionPerformed(ActionEvent e) {

        Window.appendNewEvent(DateChanger.getTime(), Window.getEventLogText());

    }

}
