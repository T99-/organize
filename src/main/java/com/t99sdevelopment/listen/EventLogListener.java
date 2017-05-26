package com.t99sdevelopment.listen;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:42 AM - March 21st, 2017.

import com.t99sdevelopment.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventLogListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		
		if (Main.mainWindow.getEventLogText().trim().length() != 0) {

			Main.mainWindow.appendNewEvent(Main.mainWindow.getEventLogText().trim());

		}

	}

}