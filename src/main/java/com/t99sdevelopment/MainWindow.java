package com.t99sdevelopment;

import javax.swing.*;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:53AM - March 14th, 2017.

public class MainWindow extends JFrame implements Runnable {

    private JPanel panel;
    private JTextArea Log_TextArea;
    private JTextField Event_TextField;
    private JButton Submit_EventButton;
    private JTextArea Time_TextArea;

    private String windowTitle;

    public MainWindow(String titleForWindow) {

        windowTitle = titleForWindow;

    }

    public void createAndShowGUI() {

        panel.add(Log_TextArea);
        panel.add(Event_TextField);
        panel.add(Submit_EventButton);
        panel.add(Time_TextArea);

        this.add(panel);

        this.setTitle(windowTitle);

        this.setVisible(true);

    }

    public void run() {

        while (true) {

            Time_TextArea.setText(DateChanger.getDate());

        }

    }

}