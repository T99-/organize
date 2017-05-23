package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45AM - March 16th, 2017.

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Window extends JFrame implements Runnable{

	public LogListModel log = new LogListModel();
	
	private JFrame frame = new JFrame();
	
		private JMenuBar menuBar = new JMenuBar();
		private JMenu file_Menu = new JMenu("File");
			private JMenuItem open_File_MenuItem = new JMenuItem("Open...");
			private JMenuItem reset_File_MenuItem = new JMenuItem("Reset Log");
			private JMenuItem close_File_MenuItem = new JMenuItem("Close");
		private JMenu edit_Menu = new JMenu("Edit");
			private JMenuItem undo_Edit_MenuItem = new JMenuItem("Undo");
			private JMenuItem redo_Edit_MenuItem = new JMenuItem("Redo");
		private JMenu about_Menu = new JMenu("About");
	
		private JPanel panel = new JPanel(new GridBagLayout());
			private JLabel time_Label = new JLabel();
			private JButton submit_Button = new JButton();
			private JTextField event_TextField = new JTextField();
			JList log_List = new JList(log.toArray()); //not sure if this being public is the best solution to the problem...
				private JPopupMenu logCell_PopupMenu = new JPopupMenu();
					private JMenuItem edit_logCell_MenuItem = new JMenuItem();
					private JMenuItem delete_logCell_MenuItem = new JMenuItem();
			private JScrollPane scrollPane = new JScrollPane(log_List, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			private JButton close_Button = new JButton();
	
		private JDialog edit_Dialog = new JDialog(frame);
			private JPanel edit_Dialog_Panel = new JPanel();
				private JTextField edit_Dialog_edit_TextField = new JTextField();
				private JPanel edit_Dialog_subpanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
				private JButton edit_Dialog_submit_Button = new JButton();
				private JButton edit_Dialog_cancel_Button = new JButton();
	
	private EventLogListener eventLogActionListener = new EventLogListener();
	private LogEditorListener logEditorActionListener = new LogEditorListener();
	private ShutdownListener shutdownActionListener = new ShutdownListener(0);
	
	private GridBagConstraints constraints = new GridBagConstraints();
	private static Dimension dimension = new Dimension(500, 200);

	public void showWindow() {

		initializeWindow();
		frame.setVisible(true);

	}

	private void initializeWindow(){
		
		initializeRightMousePopupMenu();
		initializeLogItemEditDialog();
		initializeMenuBar();
		frame.setJMenuBar(menuBar);
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
		submit_Button.addActionListener(eventLogActionListener);
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
		event_TextField.addActionListener(eventLogActionListener);
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
		close_Button.addActionListener(shutdownActionListener);
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
		
		open_File_MenuItem.setToolTipText("This doesn't do anything right now!");
		undo_Edit_MenuItem.setToolTipText("This doesn't do anything right now!");
		redo_Edit_MenuItem.setToolTipText("This doesn't do anything right now!");
		about_Menu.setToolTipText("This doesn't do anything right now!");
		
		reset_File_MenuItem.addActionListener(n -> log.clear());
		close_File_MenuItem.addActionListener(shutdownActionListener);
		
		file_Menu.add(open_File_MenuItem);
		file_Menu.addSeparator();
		file_Menu.add(reset_File_MenuItem);
		file_Menu.add(close_File_MenuItem);
		
		
		edit_Menu.add(undo_Edit_MenuItem);
		edit_Menu.add(redo_Edit_MenuItem);
		
		menuBar.add(file_Menu);
		menuBar.add(edit_Menu);
		menuBar.add(about_Menu);
	
	}
	
	private void initializeRightMousePopupMenu(){
		
		log_List.addMouseListener(new MouseAdapter(){
			
			public void mouseReleased(MouseEvent e){
				
				if(SwingUtilities.isRightMouseButton(e)){
					
					log_List.setSelectedIndex(log_List.locationToIndex(e.getPoint()));
					edit_Dialog_edit_TextField.setText(log.getEvent(log_List.getSelectedIndex()));
					logCell_PopupMenu.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
			}
			
		});
		
		edit_logCell_MenuItem.setText("Edit");
		edit_logCell_MenuItem.addActionListener(e -> edit_Dialog.setVisible(true));
		logCell_PopupMenu.add(edit_logCell_MenuItem);
		
		delete_logCell_MenuItem.setText("Delete");
		delete_logCell_MenuItem.addActionListener(e -> log.remove(log_List.getSelectedIndex()));
		logCell_PopupMenu.add(delete_logCell_MenuItem);
		
	}
	
	private void initializeLogItemEditDialog(){
		
		edit_Dialog_Panel.setLayout(new BoxLayout(edit_Dialog_Panel, BoxLayout.Y_AXIS));
		
		edit_Dialog_Panel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		// Edit JTextField (edit_Dialog_edit_TextField) option setting...
		edit_Dialog_edit_TextField.setColumns(50);
		edit_Dialog_edit_TextField.addActionListener(logEditorActionListener);
		edit_Dialog_Panel.add(edit_Dialog_edit_TextField);
		
		edit_Dialog_Panel.add(Box.createRigidArea(new Dimension(0, 5)));
		
		edit_Dialog_subpanel.add(Box.createRigidArea(new Dimension(250, 0)));
		
		// Submit JButton (edit_Dialog_submit_Button) option setting...
		edit_Dialog_submit_Button.setText("OK");
		edit_Dialog_submit_Button.addActionListener(logEditorActionListener);
		edit_Dialog_subpanel.add(edit_Dialog_submit_Button);
		
		// Cancel JButton (edit_Dialog_cancel_Button) option setting...
		edit_Dialog_cancel_Button.setText("Cancel");
		edit_Dialog_cancel_Button.addActionListener(e -> disposeEditDialog());
		edit_Dialog_subpanel.setBackground(new Color(35, 100, 50, 1));
		edit_Dialog_subpanel.add(edit_Dialog_cancel_Button);
		
		edit_Dialog_Panel.add(edit_Dialog_subpanel);
		edit_Dialog_Panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		edit_Dialog.setModal(true);
		edit_Dialog.setSize(new Dimension(500, 150));
		edit_Dialog.setTitle("Edit");
		edit_Dialog.add(edit_Dialog_Panel);
		edit_Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		edit_Dialog.pack();
		
	}
	
	public void appendNewEvent(String event){

		log.addElement(new LogItem(event));
		
		log_List.ensureIndexIsVisible(log_List.getModel().getSize() - 1);
		
		event_TextField.setText("");

	}

	public String getEventLogText(){

		return event_TextField.getText();

	}
	
	public String getEditedDialogText(){
		
		return edit_Dialog_edit_TextField.getText();
		
	}
	
	public void disposeEditDialog(){
		
		edit_Dialog.dispose();
		
	}

	public void run() {

		while(true){

			time_Label.setText(DateChanger.getTime());

		}

	}

}