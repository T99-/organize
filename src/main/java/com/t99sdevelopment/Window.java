package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45 AM - March 16th, 2017.

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Window extends JFrame implements Runnable{

	public LogListModel log = new LogListModel();
	JList log_List = new JList(log.toArray()); //not sure if this being public is the best solution to the problem...
	
	private JFrame frame = new JFrame();
		private Menu menu = new Menu();
		private JPanel panel = new JPanel(new GridBagLayout());
		private JLabel time_Label = new JLabel();
		private JButton submit_Button = new JButton();
		private JTextField event_TextField = new JTextField();
		private JScrollPane scrollPane = new JScrollPane(log_List, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		private JButton close_Button = new JButton();
	
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
		initializeMenuBar();
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
	
	private void initializeMenuBar(){
		
		menu.add(menu.file_Menu);
		menu.add(menu.edit_Menu);
		menu.add(menu.about_Menu);
	
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
	
	public void appendNewEvent(String event){

		log.addElement(new LogItem(event));
		
		log_List.ensureIndexIsVisible(log_List.getModel().getSize() - 1);
		
		event_TextField.setText("");

	}

	public String getEventLogText(){

		return event_TextField.getText();

	}

	public void run() {

		while(true){

			time_Label.setText(DateChanger.getTime());

		}

	}

}