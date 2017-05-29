package com.t99sdevelopment.listen;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 5:37 PM - March 27th, 2017

import com.t99sdevelopment.gui.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogEditorListener implements ActionListener{
	
	Window parentWindow;
	
	public LogEditorListener(Window window) {
		
		this.parentWindow = window;
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		int selectedItem_index = parentWindow.log_List.getSelectedIndex();
		String selectedItem_timestamp = parentWindow.log.getTimestampAt(selectedItem_index);
		String newEvent = parentWindow.edit_Dialog.getEditedDialogText();
		
		parentWindow.log.remove(selectedItem_index);
		parentWindow.log.add(selectedItem_index, selectedItem_timestamp + newEvent);
		
		parentWindow.edit_Dialog.disposeEditDialog();
		
	}
	
}