package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45 AM - March 16th, 2017.

import com.t99sdevelopment.log.LogItem;
import com.t99sdevelopment.log.LogItemListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Window extends JFrame {
	
	public static boolean debug = true;
	
	public LogItemListModel log = new LogItemListModel();
	public JList log_List = new JList<>(log.toArray());
	
	public Properties properties = new Properties();
	
	public Menu menu = new Menu(this);
	public Panel panel = new Panel(this);
	public PopupMenu logCell_PopupMenu = new PopupMenu(this);
	public EditDialog editDialog = new EditDialog(this);
	
	private static Dimension dimension = new Dimension(500, 200);
	
	public Window() {
	
		try {
		
			properties.load(new FileInputStream("/home/trevor/properties"));
			
		} catch (IOException e) {
		
		
		
		} catch (Exception e) {
		
		
		
		} finally {
			
			Enumeration elementNames = properties.propertyNames();
			
			while (elementNames.hasMoreElements()) {
			
				String key = (String) elementNames.nextElement();
				String value = (String) properties.getProperty(key);
				
				System.out.println(key + " -> " + value);
			
			}
		
		}
	
	}
	
	public void createWindow() {
		
		initializeWindow();
		this.setVisible(true);
		
	}
	
	private void initializeWindow() {
		
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
		editDialog.setLocationRelativeTo(null);
		
	}
	
//	public void reloadProperties() {
//
//
//
//	}
	
	private void initializeRightMousePopupMenu() {
		
		log_List.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				
				if (SwingUtilities.isRightMouseButton(e)) {
					
					log_List.setSelectedIndex(log_List.locationToIndex(e.getPoint()));
					editDialog.setText(log.getEventAt(log_List.getSelectedIndex()));
					logCell_PopupMenu.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
			}
			
		});
		
	}
	
	private void initializeEventDeleteKey() {
		
		log_List.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) { /* nothing */ }
			
			@Override
			public void keyPressed(KeyEvent e) { /* nothing */ }
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (!log_List.isSelectionEmpty()) {
					
					if (e.getKeyCode() == KeyEvent.VK_DELETE) {
						
						int selectedIndex = log_List.getSelectedIndex();
						
						if (log.size() > 0) {
							
							if (selectedIndex > 0) {
								
								log.remove(selectedIndex);
								log_List.setSelectedIndex(selectedIndex - 1);
								
							} else {
								
								log.remove(selectedIndex);
								log_List.setSelectedIndex(selectedIndex);
								
							}
							
						}
						
						
					} else if (e.getKeyCode() == KeyEvent.VK_E) {
						
						editDialog.setText(log.getEventAt(log_List.getSelectedIndex()));
						editDialog.setVisible(true);
						
					}
					
				}
				
			}
			
		});
		
	}
	
	public void appendNewEvent(String event) {
		
		log.addElement(new LogItem(event));
		
		log_List.ensureIndexIsVisible(log_List.getModel().getSize() - 1);
		
		panel.event_TextField.setText("");
		
	}
	
	public String getEventLogText() {
		
		return panel.event_TextField.getText();
		
	}
	
}