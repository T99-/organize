package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:46 AM - May 23rd, 2017

import com.t99sdevelopment.Debug;
import com.t99sdevelopment.Main;
import com.t99sdevelopment.ReadWrite;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {
	
	public JMenu file = new JMenu("File");
		public JMenuItem open_File = new JMenuItem("Open...");
		public JMenuItem save_File = new JMenuItem("Save");
		public JMenuItem saveas_File = new JMenuItem("Save As...");
		public JMenuItem exportas_File =  new JMenuItem("Export As...");
		public JMenuItem reset_File = new JMenuItem("Reset Log");
		public JMenuItem close_File = new JMenuItem("Close");
		
	public JMenu edit = new JMenu("Edit");
		public JMenuItem undo_Edit = new JMenuItem("Undo");
		public JMenuItem redo_Edit = new JMenuItem("Redo");
		
	public JMenu debug = new JMenu("Debug");
		public JMenu outputLog_Debug = new JMenu("Output to Console");
			public JMenuItem rawFormat_OutputLog = new JMenuItem("Raw Format");
			public JMenuItem niceFormat_OutputLog = new JMenuItem("Nice Format");
		public JMenu insertEvents_Debug = new JMenu("Output to Log");
			public JMenuItem eventSeries_InsertEvents = new JMenuItem("Event Series");
			public JMenuItem pseudoSeries_InsertEvents = new JMenuItem("Psuedo Events");
		public JMenuItem watchPoint_Debug = new JMenuItem("Watchpoint Trigger");
		
	public JMenu about_Menu = new JMenu("About");
	
	public Menu() {
		
		open_File.setToolTipText("This doesn't do anything right now!");
		undo_Edit.setToolTipText("This doesn't do anything right now!");
		redo_Edit.setToolTipText("This doesn't do anything right now!");
		about_Menu.setToolTipText("This doesn't do anything right now!");
		
		open_File.addActionListener(e -> ReadWrite.read());
		saveas_File.addActionListener(e -> ReadWrite.write(Main.mainWindow.log));
		reset_File.addActionListener(e -> Main.mainWindow.log.clear());
		close_File.addActionListener(e -> Main.shutdownActionListener.actionPerformed(e));
		
		file.add(open_File);
		file.add(saveas_File);
		file.addSeparator();
		file.add(reset_File);
		file.add(close_File);
		
		edit.add(undo_Edit);
		edit.add(redo_Edit);
		
		this.add(file);
		this.add(edit);
		this.add(about_Menu);
		
		if (Main.DEBUG) {
			
			rawFormat_OutputLog.addActionListener(e -> Debug.outputLog(Debug.RAW_OBJECT));
			niceFormat_OutputLog.addActionListener(e -> Debug.outputLog(Debug.NICE_FORM));
			
			outputLog_Debug.add(rawFormat_OutputLog);
			outputLog_Debug.add(niceFormat_OutputLog);
			
			debug.add(outputLog_Debug);
			
			eventSeries_InsertEvents.addActionListener(e -> Debug.insertEvents(Debug.SERIES_EVENTS));
			pseudoSeries_InsertEvents.addActionListener(e -> Debug.insertEvents(Debug.SERIES_PSEUDO));
			
			insertEvents_Debug.add(eventSeries_InsertEvents);
			insertEvents_Debug.add(pseudoSeries_InsertEvents);
			
			debug.add(insertEvents_Debug);
			
			watchPoint_Debug.addActionListener(e -> Debug.watchpointTrigger());
			
			watchPoint_Debug.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0));
			
			debug.add(watchPoint_Debug);
			
			
			this.add(debug);
			
		} else {
			
			this.remove(debug);
			
		}
		
	}
	
}