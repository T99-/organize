package com.t99sdevelopment.gui;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:55 AM - May 23rd, 2017.

import com.t99sdevelopment.listen.LogItemEditListener;

import java.awt.*;
import javax.swing.*;

public class EditDialog extends JDialog {
	
	private Window parentWindow;
	
	private JPanel panel = new JPanel();
		private JTextField edit_TextField = new JTextField();
		private JPanel buttons_SubPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		private JButton submit_Button = new JButton();
		private JButton cancel_Button = new JButton();
		
	EditDialog(Window window) {
		
		parentWindow = window;
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		// Edit JTextField (edit_TextField) option setting...
		edit_TextField.setColumns(50);
		edit_TextField.addActionListener(new LogItemEditListener(parentWindow));
		panel.add(edit_TextField);
		
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		buttons_SubPanel.add(Box.createRigidArea(new Dimension(250, 0)));
		
		// Submit JButton (submit_Button) option setting...
		submit_Button.setText("OK");
		submit_Button.addActionListener(new LogItemEditListener(parentWindow));
		buttons_SubPanel.add(submit_Button);
		
		// Cancel JButton (cancel_Button) option setting...
		cancel_Button.setText("Cancel");
		cancel_Button.addActionListener(e -> disposeEditDialog());
		buttons_SubPanel.setBackground(new Color(35, 100, 50, 1));
		buttons_SubPanel.add(cancel_Button);
		
		panel.add(buttons_SubPanel);
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		this.setModal(true);
		this.setSize(new Dimension(500, 150));
		this.setTitle("Edit");
		this.add(panel);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		
	}
	
	public void setText(String text) {
		
		edit_TextField.setText(text);
		
	}
	
	public String getEditedDialogText(){
		
		return edit_TextField.getText();
		
	}
	
	public void disposeEditDialog(){
		
		this.dispose();
		
	}
	
}