package com.t99sdevelopment.listen;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 5:37 PM - March 27th, 2017

import com.t99sdevelopment.Main;
import com.t99sdevelopment.gui.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogEditorListener implements ActionListener{
	
	Window window;
	
	public LogEditorListener(Window window) {
		
		this.window = window;
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		int selectedItem_index = window.log_List.getSelectedIndex();
		String selectedItem_timestamp = window.log.getTimestamp(selectedItem_index);
		String newEvent = window.edit_Dialog.getEditedDialogText();
		
		window.log.remove(selectedItem_index);
		window.log.add(selectedItem_index, selectedItem_timestamp + newEvent);
		
		window.edit_Dialog.disposeEditDialog();
		
	}
	
}