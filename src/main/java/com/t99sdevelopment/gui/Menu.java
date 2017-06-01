package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:46 AM - May 23rd, 2017.

import com.t99sdevelopment.Debug;
import com.t99sdevelopment.ReadWrite;
import com.t99sdevelopment.listen.ShutdownListener;

import java.awt.event.KeyEvent;
import javax.swing.*;

public class Menu extends JMenuBar {
	
	private Window parentWindow;
	
	private JMenu file = new JMenu("File");
		private JMenuItem open_File = new JMenuItem("Open...");
		private JMenuItem save_File = new JMenuItem("Save");
		private JMenuItem saveas_File = new JMenuItem("Save As...");
		private JMenuItem exportas_File =  new JMenuItem("Export As...");
		private JMenuItem reset_File = new JMenuItem("Reset Log");
		private JMenuItem close_File = new JMenuItem("Exit");
		
	private JMenu edit = new JMenu("Edit");
		private JMenuItem undo_Edit = new JMenuItem("Undo");
		private JMenuItem redo_Edit = new JMenuItem("Redo");
		
	private JMenu about_Menu = new JMenu("About");
	
	private JMenu debug = new JMenu("Debug");
		private JMenuItem disable_Debug = new JMenuItem("Disable Debug Mode");
		public JMenu outputLog_Debug = new JMenu("Output to Console");
			private JMenuItem rawFormat_OutputLog = new JMenuItem("Raw Format");
			private JMenuItem niceFormat_OutputLog = new JMenuItem("Nice Format");
		private JMenu insertEvents_Debug = new JMenu("Output to Log");
			private JMenuItem eventSeries_InsertEvents = new JMenuItem("Event Series");
			private JMenuItem pseudoSeries_InsertEvents = new JMenuItem("Pseudo Events");
			private JMenuItem watchPoint_Debug = new JMenuItem("Watchpoint Trigger");
	
	Menu(Window window) {
		
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
		
		if (parentWindow.debug) {
			
			//TODO - Allow the user to toggle debug back on once it has been disabled via this JMenu.
			
			disable_Debug.addActionListener(e -> Debug.toggleDebug(parentWindow));
			
			disable_Debug.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
			
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
			
		}/* else {
			
			this.remove(debug);
			
		}*/
		
	}
	
	public void toggleDebugVisibility() {
	
		boolean currentlyVisible = this.isAncestorOf(debug);
		
		if (currentlyVisible) {
			
			debug.setVisible(false);
			
		} else {
			
			debug.setVisible(true);
			
		}
		
		this.revalidate();
	
	}
	
	public void setDebugVisibility(boolean visible) {
		
		if (visible && !isAncestorOf(debug)) {
			
			this.add(debug);
			
		} else if (!visible && this.isAncestorOf(debug)) {
			
			this.remove(debug);
			
		}
		
		this.revalidate();
		
	}
	
}