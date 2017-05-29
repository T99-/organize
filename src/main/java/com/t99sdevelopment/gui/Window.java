package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45 AM - March 16th, 2017.

import com.t99sdevelopment.LogItem;
import com.t99sdevelopment.LogListModel;
import com.t99sdevelopment.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

	public LogListModel log = new LogListModel();
	public JList log_List = new JList(log.toArray()); // not sure if this being public is the best solution to the problem...
	
	public Menu menu = new Menu();
	public Panel panel = new Panel(this);
	public PopupMenu logCell_PopupMenu = new PopupMenu();
	public EditDialog edit_Dialog = new EditDialog(this);
	
	private static Dimension dimension = new Dimension(500, 200);
	
	public void createWindow() {

		initializeWindow();
		this.setVisible(true);

	}

	private void initializeWindow(){
		
		initializeRightMousePopupMenu();
		initializeEventDeleteKey();
		this.setJMenuBar(menu);
		this.add(panel);
		this.setTitle("organize");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(dimension);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		edit_Dialog.setLocationRelativeTo(null);

	}
	
	private void initializeRightMousePopupMenu(){
		
		Main.mainWindow.log_List.addMouseListener(new MouseAdapter(){
			
			public void mouseReleased(MouseEvent e){
				
				if(SwingUtilities.isRightMouseButton(e)){
					
					Main.mainWindow.log_List.setSelectedIndex(Main.mainWindow.log_List.locationToIndex(e.getPoint()));
					Main.mainWindow.edit_Dialog.edit_Dialog_edit_TextField.setText(Main.mainWindow.log.getEvent(Main.mainWindow.log_List.getSelectedIndex()));
					logCell_PopupMenu.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
			}
			
		});
		
	}
	
	private void initializeEventDeleteKey(){

		Main.mainWindow.log_List.addKeyListener(new KeyAdapter(){
			
			@Override
			public void keyTyped(KeyEvent e){ /* nothing */ }
			
			@Override
			public void keyPressed(KeyEvent e){ /* nothing */ }
			
			@Override
			public void keyReleased(KeyEvent e){
				
				if (!Main.mainWindow.log_List.isSelectionEmpty()) {
					
					if (e.getKeyCode() == KeyEvent.VK_DELETE) {
						
						Main.mainWindow.log.remove(Main.mainWindow.log_List.getSelectedIndex());
						
					} else if (e.getKeyCode() == KeyEvent.VK_E) {
						
						Main.mainWindow.edit_Dialog.edit_Dialog_edit_TextField.setText(Main.mainWindow.log.getEvent(Main.mainWindow.log_List.getSelectedIndex()));
						Main.mainWindow.edit_Dialog.setVisible(true);
						
					}
					
				}
				
			}
			
		});

	}
	
	public void appendNewEvent(String event){

		log.addElement(new LogItem(event));
		
		log_List.ensureIndexIsVisible(log_List.getModel().getSize() - 1);
		
		panel.event_TextField.setText("");

	}

	public String getEventLogText(){

		return panel.event_TextField.getText();

	}

}