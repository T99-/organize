package com.t99sdevelopment.listen;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 9:12 AM - March 19th, 2017.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShutdownListener implements ActionListener {

	private static int exitStatus;

	public ShutdownListener(int exitStatus) {

		this.exitStatus = exitStatus;

	}

	public ShutdownListener() {

		this.exitStatus = 0;

	}

	public void actionPerformed(ActionEvent e) {

		System.exit(exitStatus);

	}

}