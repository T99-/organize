package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:46 AM - May 23, 2017

import javax.swing.*;

public class Menu extends JMenuBar {
	
	public JMenu file_Menu = new JMenu("File");
		public JMenuItem open_File_MenuItem = new JMenuItem("Open...");
		public JMenuItem reset_File_MenuItem = new JMenuItem("Reset Log");
		public JMenuItem close_File_MenuItem = new JMenuItem("Close");
		
	public JMenu edit_Menu = new JMenu("Edit");
		public JMenuItem undo_Edit_MenuItem = new JMenuItem("Undo");
		public JMenuItem redo_Edit_MenuItem = new JMenuItem("Redo");
		
	public JMenu about_Menu = new JMenu("About");
	
	public Menu() {
		
		open_File_MenuItem.setToolTipText("This doesn't do anything right now!");
		undo_Edit_MenuItem.setToolTipText("This doesn't do anything right now!");
		redo_Edit_MenuItem.setToolTipText("This doesn't do anything right now!");
		about_Menu.setToolTipText("This doesn't do anything right now!");
		
		reset_File_MenuItem.addActionListener(e -> Main.mainWindow.log.clear());
		close_File_MenuItem.addActionListener(e -> Main.shutdownActionListener.actionPerformed(e));
		
		file_Menu.add(open_File_MenuItem);
		file_Menu.addSeparator();
		file_Menu.add(reset_File_MenuItem);
		file_Menu.add(close_File_MenuItem);
		
		
		edit_Menu.add(undo_Edit_MenuItem);
		edit_Menu.add(redo_Edit_MenuItem);
		
	}
	
}