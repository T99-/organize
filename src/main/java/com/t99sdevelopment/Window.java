package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45AM - March 16th, 2017.

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame implements Runnable{

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new GridBagLayout());
    private JLabel time_Label = new JLabel();
    private JButton submit_Button = new JButton();
    private JTextField event_TextField = new JTextField();
    private JTextArea log_TextArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(log_TextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JButton close_Button = new JButton();

    private GridBagConstraints constraints = new GridBagConstraints();
    private Dimension dimension = new Dimension(500, 200);

    private String windowTitle;
    
    public Window(String title){

        windowTitle = title;

    }

    public void showWindow() {

        initializeWindow();
        frame.setVisible(true);

    }

    private void initializeWindow(){

        initializePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(windowTitle);
        frame.setMinimumSize(dimension);
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);

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
        EventLogListener eventLogActionListener = new EventLogListener(time_Label.getText());
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
        event_TextField.setText("example event text here");
        event_TextField.setColumns(50);
        event_TextField.setEditable(true);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.95;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0,3,5,5);
        panel.add(event_TextField, constraints);

        // Logs JTextArea (logs_TextArea) option setting...
        log_TextArea.setText("[06:24:33 PM] Example log message displayed here.\n[06:25:13 PM] Another example log message displayed here.");
        log_TextArea.setEditable(false);
        log_TextArea.setSize(new Dimension(400, 400));
        log_TextArea.setColumns(100);
        log_TextArea.setRows(20);
        log_TextArea.setLineWrap(true);
        log_TextArea.setWrapStyleWord(true);
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
        ShutdownListener shutdownActionListener = new ShutdownListener(0);
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

    public String getEventLogText(){

        return event_TextField.getText();

    }

    public void run() {

        while(true){

            time_Label.setText(DateChanger.getDate());

        }

    }

}