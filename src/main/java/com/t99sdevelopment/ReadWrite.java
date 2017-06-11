package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 12:37 PM - May 23rd, 2017.

import com.t99sdevelopment.gui.Window;
import com.t99sdevelopment.log.LogItemListModel;

import com.google.gson.Gson;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadWrite {
	
	static Gson converter = new Gson();
	static final FileNameExtensionFilter logFilter = new FileNameExtensionFilter("Log Files", "log");
	static final FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files", "txt");
	
	public static void write(Window parentWindow, Object obj) {
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
		chooser.addChoosableFileFilter(logFilter);
		chooser.addChoosableFileFilter(txtFilter);
		chooser.setFileFilter(logFilter);
		
		int k = chooser.showSaveDialog(parentWindow);
		
		if (k == JFileChooser.APPROVE_OPTION) {
		
			File file = chooser.getSelectedFile();
			String fileName = file.getAbsolutePath();
			
			if (!fileName.endsWith(".log")) {
				
				fileName += ".log";
				
			}
			
			file = new File(fileName);
			
			if (parentWindow.log.size() != 0) {
				
				try {
					
					FileWriter writer = new FileWriter(file);
					BufferedWriter bufferedWriter = new BufferedWriter(writer);
					
					converter.toJson(obj, bufferedWriter);
					
					bufferedWriter.close();
					
					
				} catch(IOException e) {
					
					JOptionPane.showMessageDialog(parentWindow, "There was a problem saving the file...");
					write(parentWindow, obj);
					
				}
			
			} else {
				
				JOptionPane.showMessageDialog(parentWindow, "You can't save an empty file!");
			
			}
			
		}
		
	}
	
	public static void read(Window parentWindow) {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.addChoosableFileFilter(logFilter);
		chooser.addChoosableFileFilter(txtFilter);
		chooser.setFileFilter(logFilter);
		
		int k = chooser.showOpenDialog(parentWindow);
		
		if (k == JFileChooser.APPROVE_OPTION) {
			
			File file = chooser.getSelectedFile();
			
			try {
				
				parentWindow.log = converter.fromJson(new FileReader(file), LogItemListModel.class);
				parentWindow.log_List.setModel(parentWindow.log);
				
			} catch (IOException e) {
				
				JOptionPane.showMessageDialog(parentWindow, "There was a problem opening the file...");
				read(parentWindow);
				
			}
			
		}
		
	}
	
}