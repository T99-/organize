package com.t99sdevelopment.listen;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 5:37 PM - March 27th, 2017

import com.t99sdevelopment.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogEditorListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		int selectedItem_index = Main.mainWindow.log_List.getSelectedIndex();
		String selectedItem_timestamp = Main.mainWindow.log.getTimestamp(selectedItem_index);
		String newEvent = Main.mainWindow.edit_Dialog.getEditedDialogText();
		
		Main.mainWindow.log.remove(selectedItem_index);
		Main.mainWindow.log.add(selectedItem_index, selectedItem_timestamp + newEvent);
		
		Main.mainWindow.edit_Dialog.disposeEditDialog();
		
	}
	
}