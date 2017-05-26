package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45 AM - March 16th, 2017.

import com.t99sdevelopment.DateChanger;
import com.t99sdevelopment.LogItem;
import com.t99sdevelopment.LogListModel;
import com.t99sdevelopment.Main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Window extends JFrame implements Runnable{

	public LogListModel log = new LogListModel();
	public JList log_List = new JList(log.toArray()); // not sure if this being public is the best solution to the problem...
	
	public JFrame frame = new JFrame();
		public Menu menu = new Menu();
		public JPanel panel = new JPanel(new GridBagLayout());
		public JLabel time_Label = new JLabel();
		public JButton submit_Button = new JButton();
		public JTextField event_TextField = new JTextField();
		public JScrollPane scrollPane = new JScrollPane(log_List, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		public JButton close_Button = new JButton();
	
	public PopupMenu logCell_PopupMenu = new PopupMenu();
	public EditDialog edit_Dialog = new EditDialog();
	
	private GridBagConstraints constraints = new GridBagConstraints();
	private static Dimension dimension = new Dimension(500, 200);

	public void showWindow() {

		initializeWindow();
		frame.setVisible(true);

	}

	private void initializeWindow(){
		
		initializeRightMousePopupMenu();
		initializeEventDeleteKey();
		frame.setJMenuBar(menu);
		initializePanel();
		frame.add(panel);
		frame.setTitle("organize");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(dimension);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		edit_Dialog.setLocationRelativeTo(null);

	}

	private void initializePanel(){

		// Time JLabel (time_Label) option setting...
		time_Label.setHorizontalAlignment(JTextField.CENTER);
		time_Label.setFont(new Font("Serif", Font.BOLD, 18));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.05;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(5,0,0,0);
		panel.add(time_Label, constraints);

		// Submit JButton (submit_Button) option setting...
		submit_Button.setText("Submit");
		submit_Button.addActionListener(Main.eventLogActionListener);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.05;
		constraints.weighty = 0.1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0,5,5,3);
		panel.add(submit_Button, constraints);

		// Event JTextField (event_TextField) option setting...
		event_TextField.setColumns(50);
		event_TextField.setEditable(true);
		event_TextField.addActionListener(Main.eventLogActionListener);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 0.95;
		constraints.weighty = 0.1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0,3,5,5);
		panel.add(event_TextField, constraints);
		
		// Logs JList (logs_TextArea) option setting...
		log_List.setModel(log);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.9;
		constraints.ipady = 40;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0,5,0,5);
		panel.add(scrollPane, constraints);

		// Close JButton (close_Button) option setting...
		close_Button.setText("Close");
		close_Button.addActionListener(Main.shutdownActionListener);
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 0.05;
		constraints.ipady = 0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.insets = new Insets(0,0,0,10);
		panel.add(close_Button, constraints);

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
		
		event_TextField.setText("");

	}

	public String getEventLogText(){

		return event_TextField.getText();

	}
	
	public void refreshLogList() {
		
		log_List = new JList(log.toArray());
		
	}

	public void run() {

		while(true){

			time_Label.setText(DateChanger.getTime());

		}

	}

}