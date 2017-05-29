package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:17 AM - May 23, 2017

import com.t99sdevelopment.Main;

import javax.swing.*;

public class PopupMenu extends JPopupMenu {
	
	Window parentWindow;
	
	public JMenuItem edit_logCell_MenuItem = new JMenuItem();
	public JMenuItem delete_logCell_MenuItem = new JMenuItem();
	
	public PopupMenu(Window window) {
		
		parentWindow = window;
		
		edit_logCell_MenuItem.setText("Edit");
		edit_logCell_MenuItem.addActionListener(e -> parentWindow.edit_Dialog.setVisible(true));
		this.add(edit_logCell_MenuItem);
		
		delete_logCell_MenuItem.setText("Delete");
		delete_logCell_MenuItem.addActionListener(e -> parentWindow.log.remove(parentWindow.log_List.getSelectedIndex()));
		this.add(delete_logCell_MenuItem);
		
	}
	
}