package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 8:28 PM - May 28, 2017

import com.t99sdevelopment.DateChanger;
import com.t99sdevelopment.listen.EventLogListener;
import com.t99sdevelopment.listen.ShutdownListener;

import javax.swing.*;
import java.util.Timer;
import java.awt.*;
import java.util.TimerTask;

public class Panel extends JPanel {
	
	Window window;
	
	public JLabel time_Label = new JLabel();
	public JButton submit_Button = new JButton();
	public JTextField event_TextField = new JTextField();
	public JScrollPane scrollPane; // Initialization deferred to constructor in order to access the parent window's log_List field.
	public JButton close_Button = new JButton();
	
	private GridBagConstraints constraints = new GridBagConstraints();
	
	{
		
		Timer updater = new Timer(true);
		updater.schedule(new TimerTask() { public void run() { time_Label.setText(DateChanger.getTime());} }, 0, 1000);
		
	}
	
	public Panel(Window window) {
		
		super(new GridBagLayout());
		
		scrollPane = new JScrollPane(window.log_List, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.window = window;
		
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
		this.add(time_Label, constraints);
		
		// Submit JButton (submit_Button) option setting...
		submit_Button.setText("Submit");
		submit_Button.addActionListener(new EventLogListener(window));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.05;
		constraints.weighty = 0.1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0,5,5,3);
		this.add(submit_Button, constraints);
		
		// Event JTextField (event_TextField) option setting...
		event_TextField.setColumns(50);
		event_TextField.setEditable(true);
		event_TextField.addActionListener(new EventLogListener(window));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 0.95;
		constraints.weighty = 0.1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0,3,5,5);
		this.add(event_TextField, constraints);
		
		// Logs JList (logs_TextArea) option setting...
		window.log_List.setModel(window.log);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.9;
		constraints.ipady = 40;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0,5,0,5);
		this.add(scrollPane, constraints);
		
		// Close JButton (close_Button) option setting...
		close_Button.setText("Exit");
		close_Button.addActionListener(new ShutdownListener());
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 0.05;
		constraints.ipady = 0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.insets = new Insets(3,0,3,10);
		this.add(close_Button, constraints);
		
	}
	
}