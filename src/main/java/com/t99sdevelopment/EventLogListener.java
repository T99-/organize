package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:42 AM - March 21st, 2017.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventLogListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		if(Main.mainWindow.getEventLogText().trim().length() != 0){

			Main.mainWindow.appendNewEvent(Main.mainWindow.getEventLogText().trim());

		}

	}

}