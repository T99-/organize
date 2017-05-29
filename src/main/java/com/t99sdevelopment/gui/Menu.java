package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:46 AM - May 23rd, 2017

import com.t99sdevelopment.Debug;
import com.t99sdevelopment.Main;
import com.t99sdevelopment.ReadWrite;
import com.t99sdevelopment.listen.ShutdownListener;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {
	
	Window parentWindow;
	
	public JMenu file = new JMenu("File");
		public JMenuItem open_File = new JMenuItem("Open...");
		public JMenuItem save_File = new JMenuItem("Save");
		public JMenuItem saveas_File = new JMenuItem("Save As...");
		public JMenuItem exportas_File =  new JMenuItem("Export As...");
		public JMenuItem reset_File = new JMenuItem("Reset Log");
		public JMenuItem close_File = new JMenuItem("Exit");
		
	public JMenu edit = new JMenu("Edit");
		public JMenuItem undo_Edit = new JMenuItem("Undo");
		public JMenuItem redo_Edit = new JMenuItem("Redo");
		
	public JMenu debug = new JMenu("Debug");
		public JMenuItem disable_Debug = new JMenuItem("Disable Debug Mode");
		public JMenu outputLog_Debug = new JMenu("Output to Console");
			public JMenuItem rawFormat_OutputLog = new JMenuItem("Raw Format");
			public JMenuItem niceFormat_OutputLog = new JMenuItem("Nice Format");
		public JMenu insertEvents_Debug = new JMenu("Output to Log");
			public JMenuItem eventSeries_InsertEvents = new JMenuItem("Event Series");
			public JMenuItem pseudoSeries_InsertEvents = new JMenuItem("Psuedo Events");
		public JMenuItem watchPoint_Debug = new JMenuItem("Watchpoint Trigger");
		
	public JMenu about_Menu = new JMenu("About");
	
	public Menu(Window window) {
		
		parentWindow = window;
		
		undo_Edit.setToolTipText("This doesn't do anything right now!");
		redo_Edit.setToolTipText("This doesn't do anything right now!");
		about_Menu.setToolTipText("This doesn't do anything right now!");
		
		open_File.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		saveas_File.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		reset_File.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		
		open_File.addActionListener(e -> ReadWrite.read());
		saveas_File.addActionListener(e -> ReadWrite.write(parentWindow.log));
		reset_File.addActionListener(e -> parentWindow.log.clear());
		close_File.addActionListener(new ShutdownListener());
		
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
		
		if (parentWindow.DEBUG) {
			
			disable_Debug.addActionListener(e -> parentWindow.DEBUG = !parentWindow.DEBUG);
			
			debug.add(disable_Debug);
			
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
	
	public void toggleDebug() {
	
	
	
	}
	
	public void toggleDebug(boolean state) {
	
	
	
	}
	
}