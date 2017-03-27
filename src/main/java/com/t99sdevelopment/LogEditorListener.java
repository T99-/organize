package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 5:37 PM - March 27, 2017

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogEditorListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		int selectedItem_index = Window.log_List.getSelectedIndex();
		String selectedItem_timestamp = Window.log.getTimestamp(selectedItem_index);
		String newEvent = Window.getEditedDialogText();
		
		Window.log.remove(selectedItem_index);
		Window.log.add(selectedItem_index, selectedItem_timestamp + newEvent);
		
		Window.disposeEditDialog();
		
	}
	
}