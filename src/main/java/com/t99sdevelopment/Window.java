package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45AM - March 16th, 2017.

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame implements Runnable{

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new GridBagLayout());
    private JLabel time_Label = new JLabel();
    private JButton close_Button = new JButton();

    private GridBagConstraints constraints = new GridBagConstraints();
    private Dimension dimension = new Dimension(300, 100);

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
        frame.add(panel);
        frame.setResizable(false);
        frame.setSize(dimension);
        frame.setLocationRelativeTo(null);

    }

    private void initializePanel(){

        // Time JLabel (time_Label) option setting...
        time_Label.setHorizontalAlignment(JTextField.CENTER);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(time_Label, constraints);

        // Close JButton (close_Button) option setting...
        close_Button.setText("Close");
        Close closeActionListener = new Close(0);
        close_Button.addActionListener(closeActionListener);
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,0,0,10);
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 2;
        constraints.gridy = 2;
        panel.add(close_Button, constraints);

    }

    public void run() {

        while(true){

            time_Label.setText(DateChanger.getDate());

        }

    }

}