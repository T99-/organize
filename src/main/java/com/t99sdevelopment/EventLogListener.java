package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:42AM - March 21st, 2017.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventLogListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {

        if(Window.getEventLogText().trim().length() != 0){

            Window.appendNewEvent(DateChanger.getTime(), Window.getEventLogText().trim());

        }

    }

}
