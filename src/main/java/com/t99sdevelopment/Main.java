package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:40 AM - March 14th, 2017.

import com.t99sdevelopment.gui.Window;

/**
 * The main, originally executed class of the program.
 *
 * This class creates a static instance of the {@link com.t99sdevelopment.gui.Window} class that will be used throughout the program.
 *
 * @author Trevor Sears
 * @version v0.4.0
 * @since 5/14/17
 * @see com.t99sdevelopment.gui.Window
 *
 */
public class Main {
	
	public static Window mainWindow = new Window();
	
	/**
	 * Brief summary of method, ending with a period.
	 *
	 * Further description of method and what it does, including as much detail as is
	 * appropriate.  Inline tags such as
	 * {@code code here}, {@link some.other.Docs}, and {@literal text here} can be used.
	 *
	 * If a method overrides a superclass method, {@inheritDoc} can be used to copy the
	 * documentation
	 * from the superclass method
	 *
	 * @param stream Describe this parameter.  Include as much detail as is appropriate
	 *               Parameter docs are commonly aligned as here, but this is optional.
	 *               As with other docs, the documentation before the first period is
	 *               used as a summary.
	 *
	 * @return Describe the return values.  Include as much detail as is appropriate
	 *         Return type docs are commonly aligned as here, but this is optional.
	 *         As with other docs, the documentation before the first period is used as a
	 *         summary.
	 *
	 * @throws IOException Describe when and why this exception can be thrown.
	 *                     Exception docs are commonly aligned as here, but this is
	 *                     optional.
	 *                     As with other docs, the documentation before the first period
	 *                     is used as a summary.
	 *                     Instead of @throws, @exception can also be used.
	 *
	 * @since 2.1.0
	 * @see some.other.class.Documentation
	 * @deprecated  Describe why this method is outdated. A replacement can also be specified.
	 */
	public static void main(String[] args) {
		
		mainWindow.createWindow();
		
	}

}