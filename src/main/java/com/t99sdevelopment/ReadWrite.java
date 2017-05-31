package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 12:37 PM - May 23rd, 2017.

import com.t99sdevelopment.log.LogListModel;

import com.google.gson.Gson;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadWrite {
	
	static Gson converter = new Gson();
	static final FileNameExtensionFilter logFilter = new FileNameExtensionFilter("Log Files", "log");
	static final FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files", "txt");
	
	public static void write(Object obj) {
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
		chooser.addChoosableFileFilter(logFilter);
		chooser.addChoosableFileFilter(txtFilter);
		chooser.setFileFilter(logFilter);
		
		int k = chooser.showSaveDialog(Main.mainWindow);
		
		if (k == JFileChooser.APPROVE_OPTION) {
		
			File file = chooser.getSelectedFile();
			String fileName = file.getAbsolutePath();
			
			if (!fileName.endsWith(".log")) {
				
				fileName += ".log";
				
			}
			
			file = new File(fileName);
			
			try {
				
				FileWriter writer = new FileWriter(file);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				
				converter.toJson(obj, bufferedWriter);
				
				bufferedWriter.close();
				
				
			} catch(IOException e) {
				
				System.out.println("There was an problem opening the file...");
				
			}
			
		}
		
	}
	
	public static void read() {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		chooser.addChoosableFileFilter(logFilter);
		chooser.addChoosableFileFilter(txtFilter);
		chooser.setFileFilter(logFilter);
		
		int k = chooser.showOpenDialog(Main.mainWindow);
		
		if (k == JFileChooser.APPROVE_OPTION) {
			
			File file = chooser.getSelectedFile();
			
			try {
				
				Main.mainWindow.log = converter.fromJson(new FileReader(file), LogListModel.class);
				Main.mainWindow.log_List.setModel(Main.mainWindow.log);
				
			} catch (IOException e) {
				
				System.out.println("There was a problem reading from the file...");
				
			}
			
		}
		
	}
	
}