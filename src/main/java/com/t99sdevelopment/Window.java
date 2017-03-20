package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 11:45AM - March 16th, 2017.

import java.awt.*;
import java.awt.event.ActionListener;
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

        addItem(
                time_Label,
                GridBagConstraints.HORIZONTAL,
                3,
                1,
                0.5,
                0.5,
                2,
                2
        );

        // Close JButton (close_Button) option setting...

        close_Button.setText("Close");
        Close closeActionListener = new Close(0);
        close_Button.addActionListener(closeActionListener);

        addItem(
                close_Button,
                GridBagConstraints.HORIZONTAL,
                1,
                1,
                0.5,
                0.5,
                3,
                3
        );

    }

    private void addItem(Component component, int fillValue, int gridwidthValue, int gridheightValue, double weightxValue, double weightyValue, int gridxValue, int gridyValue){

        constraints.fill = fillValue;
        constraints.gridwidth = gridwidthValue;
        constraints.gridheight = gridheightValue;
        constraints.weightx = weightxValue;
        constraints.weighty = weightyValue;
        constraints.gridx = gridxValue;
        constraints.gridy = gridyValue;

        panel.add(component, constraints);

    }

    public void run() {

        while(true){

            time_Label.setText(DateChanger.getDate());

        }

    }

}