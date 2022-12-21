
package com.converter.modules;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.parser.DTD;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import styled ui-elements
import com.converter.modules.ConvertBtn;
import com.converter.modules.Title;
import com.converter.modules.windows.setIsbnWin;
import com.converter.modules.TargetFldrSlctr;
import com.converter.modules.Panel;
import com.converter.modules.windows.accdbPath;
import com.converter.modules.windows.mdbPath;

/**
 * 
 * @author Maxwell
 * 
 * Main Window class for the application
 *
 */

//for learning
//isn't used
class ItemAction implements ActionListener {
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Jup so funktionierts");
	}
}

//frontend
public class Window {

	//global properties of the Window
	private int height;
	private int width;
	private String title;
	private JFrame win;
	
	//Menubar
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem debug;
	private JMenuItem config;
	
	//Developer Menu
	private JMenu devmenu;
	private JMenuItem databPath;
	private JMenuItem lenIsbn;
	private JMenuItem accdb;
	private setIsbnWin isbnWin;
	private mdbPath databasePath;
	private accdbPath accDbPath;
	
	//content panel
	private Panel pane;
	//application icon (doesnt work tho)
	private ImageIcon icon;
	
	//Developer//
	//database string -> where the development
	//database is stored
	public String dbstr;

	//Constructor
	public Window(int height, int width, String title) {
		
		//set width height and title
		//width and height are not really used
		//but were important for first versions
		//of this application
		this.height = height;
		this.width = width;
		this.title = title;
		
	}
	
	//create the window
	public void create() {
		
		// sets the icon for the jframe
		icon = new ImageIcon("../static/logo.png");
		//initiate the window
		win = new JFrame();
		win.setTitle(this.title);
		//win.setSize(this.width, this.height);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		win.setIconImage(icon.getImage());

		//panel with content
		pane = new Panel();
		win.setContentPane(pane);
		
		//Menubar
		menubar = new JMenuBar();
		menu = new JMenu("Einstellungen");
		debug = new JMenuItem("Toggle Debug Mode");
		config = new JMenuItem("Konfiguriere Speicherverzeichnis");
		//submenu
		devmenu = new JMenu("Developer");
		databPath = new JMenuItem("Set author database path");
		lenIsbn = new JMenuItem("Set length of ISBN");
		accdb = new JMenuItem("Set info database path");
		isbnWin = new setIsbnWin("Set length of ISBN");
		databasePath = new mdbPath("Set Author database path");
		accDbPath = new accdbPath("Set onix/ebook database path");


		debug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.debug();
			}
		});

		config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.setTgPath();
			}
		});

		databPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				databasePath.showWin();
				System.out.println("Setting Database path");
			}
		});

		accdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accDbPath.showWin();
				System.out.println("Setting author database path");
			}
		});

		lenIsbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isbnWin.showWin();
				System.out.println("Setting length of ISBN");
			}
		});

		//submenu
		devmenu.add(databPath);
		devmenu.add(accdb);
		devmenu.add(lenIsbn);
		
		//menu
		menu.add(debug);
		menu.add(config);
		menu.add(devmenu);
		
		//menubar
		menubar.add(menu);
		
		win.setResizable(false);
		win.pack();
		win.setJMenuBar(menubar);
	
	}

	public String dbString() {
		return(dbstr);
	}
	
	//is used in other scripts
	//dont change
	public void show() {
		
		win.setVisible(true);
		
	}
}
