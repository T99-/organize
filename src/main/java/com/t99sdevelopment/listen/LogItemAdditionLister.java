package com.t99sdevelopment.listen;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:42 AM - March 21st, 2017.

import com.t99sdevelopment.gui.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogItemAdditionLister implements ActionListener {
	
	private Window parentWindow;
	
	public LogItemAdditionLister(Window window) {
		
		this.parentWindow = window;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		String editorText = parentWindow.getEventLogText().trim();
		
		if (editorText.length() != 0) {

			parentWindow.appendNewEvent(editorText);

		}

	}

}