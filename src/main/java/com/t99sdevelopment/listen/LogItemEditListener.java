package com.t99sdevelopment.listen;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 5:37 PM - March 27th, 2017.

import com.t99sdevelopment.gui.Window;
import com.t99sdevelopment.log.LogItem;
import com.t99sdevelopment.log.LogTimestamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogItemEditListener implements ActionListener {
	
	private Window parentWindow;
	
	public LogItemEditListener(Window window) {
		
		this.parentWindow = window;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		int selectedIndex = parentWindow.log_List.getSelectedIndex();
		LogTimestamp oldTimestamp = parentWindow.log.getElementAt(selectedIndex).getTimestamp();
		String newEvent = parentWindow.editDialog.getEditedDialogText();
		
		parentWindow.log.remove(selectedIndex);
		parentWindow.log.add(selectedIndex, new LogItem(newEvent, oldTimestamp));
		
		parentWindow.editDialog.disposeEditDialog();
		
	}
	
}