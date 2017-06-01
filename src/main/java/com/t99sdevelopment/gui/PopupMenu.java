package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:17 AM - May 23, 2017.

import javax.swing.*;

public class PopupMenu extends JPopupMenu {
	
	private Window parentWindow;
	
	private JMenuItem edit_MenuItem = new JMenuItem();
	private JMenuItem delete_MenuItem = new JMenuItem();
	
	PopupMenu(Window window) {
		
		parentWindow = window;
		
		edit_MenuItem.setText("Edit");
		edit_MenuItem.addActionListener(e -> parentWindow.editDialog.setVisible(true));
		this.add(edit_MenuItem);
		
		delete_MenuItem.setText("Delete");
		delete_MenuItem.addActionListener(e -> parentWindow.log.remove(parentWindow.log_List.getSelectedIndex()));
		this.add(delete_MenuItem);
		
	}
	
}