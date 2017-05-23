package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 10:55 AM - May 23, 2017

import javax.swing.*;
import java.awt.*;

public class EditDialog extends JDialog {
	
	public JPanel edit_Dialog_Panel = new JPanel();
		public JTextField edit_Dialog_edit_TextField = new JTextField();
		public JPanel edit_Dialog_subpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
		public JButton edit_Dialog_submit_Button = new JButton();
		public JButton edit_Dialog_cancel_Button = new JButton();
		
	public EditDialog() {
		
		edit_Dialog_Panel.setLayout(new BoxLayout(edit_Dialog_Panel, BoxLayout.Y_AXIS));
		
		edit_Dialog_Panel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		// Edit JTextField (edit_Dialog_edit_TextField) option setting...
		edit_Dialog_edit_TextField.setColumns(50);
		edit_Dialog_edit_TextField.addActionListener(Main.logEditorActionListener);
		edit_Dialog_Panel.add(edit_Dialog_edit_TextField);
		
		edit_Dialog_Panel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		edit_Dialog_subpanel.add(Box.createRigidArea(new Dimension(250, 0)));
		
		// Submit JButton (edit_Dialog_submit_Button) option setting...
		edit_Dialog_submit_Button.setText("OK");
		edit_Dialog_submit_Button.addActionListener(e -> Main.logEditorActionListener.actionPerformed(e));
		edit_Dialog_subpanel.add(edit_Dialog_submit_Button);
		
		// Cancel JButton (edit_Dialog_cancel_Button) option setting...
		edit_Dialog_cancel_Button.setText("Cancel");
		edit_Dialog_cancel_Button.addActionListener(e -> disposeEditDialog());
		edit_Dialog_subpanel.setBackground(new Color(35, 100, 50, 1));
		edit_Dialog_subpanel.add(edit_Dialog_cancel_Button);
		
		edit_Dialog_Panel.add(edit_Dialog_subpanel);
		edit_Dialog_Panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		this.setModal(true);
		this.setSize(new Dimension(500, 150));
		this.setTitle("Edit");
		this.add(edit_Dialog_Panel);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		
	}
	
	public void setTextFieldText(String text) {
		
		edit_Dialog_edit_TextField.setText(text);
		
	}
	
	public String getEditedDialogText(){
		
		return edit_Dialog_edit_TextField.getText();
		
	}
	
	public void disposeEditDialog(){
		
		this.dispose();
		
	}
}
