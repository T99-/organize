package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:17 AM - May 23, 2017

import javax.swing.*;

public class PopupMenu extends JPopupMenu {
	
	public JMenuItem edit_logCell_MenuItem = new JMenuItem();
	public JMenuItem delete_logCell_MenuItem = new JMenuItem();
	
	public PopupMenu() {
		
		edit_logCell_MenuItem.setText("Edit");
		edit_logCell_MenuItem.addActionListener(e -> Main.mainWindow.edit_Dialog.setVisible(true));
		this.add(edit_logCell_MenuItem);
		
		delete_logCell_MenuItem.setText("Delete");
		delete_logCell_MenuItem.addActionListener(e -> Main.mainWindow.log.remove(Main.mainWindow.log_List.getSelectedIndex()));
		this.add(delete_logCell_MenuItem);
		
	}
	
}