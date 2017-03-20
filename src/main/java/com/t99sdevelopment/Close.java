package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 9:12AM - March 19th, 2017.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Close implements ActionListener{

    int exitStatus = 0;

    public Close(int exitStatus){

        this.exitStatus = exitStatus;

    }

    public Close(){



    }

    public void actionPerformed(ActionEvent e) {

        System.exit(exitStatus);

    }

}
