
package com.converter;
import com.converter.modules.Window;
import javax.swing.*;

/**
 * 
 * @author Maxwell
 * 
 * This is the main logic/backend class for the
 * application
 * 
 *
 */

public class App {

	//Copyright Symbol
	private static char cSymbol = 169;
	//Copyright Symbol as String
	private static String symbol = Character.toString(cSymbol);
	//Main application window
	public static Window win;
	
	//main function of the application
	public static void main(String[] args) {
	
		//the main window
		win = new Window(300, 300, "Konverter - " + symbol + "Maxwell Leu");
		
		//for multithreading
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	win.create();
        		win.show();
            }
        });

	}

}
