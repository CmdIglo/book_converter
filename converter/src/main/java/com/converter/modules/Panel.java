
package com.converter.modules;

import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.LineBorder;

import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.converter.modules.ConvertBtn;
import com.converter.modules.TargetFldrSlctr;
import com.converter.modules.Title;
import com.converter.modules.Footer;

import com.converter.modules.functions.Tokenizer;
import com.converter.modules.functions.Config;
import com.converter.modules.functions.ReadACCDB;
import com.converter.modules.functions.ReadMDB;

/** 
 * @author: Maxwell Leu
 * @version 1.0.0
 * 
 * This is the panel displayed as the Main-Frame
 * 
 * */

public class Panel extends JPanel {

	//initialization of the attributes/variables
	private static final long serialVersionUID = 1L;
	private ConvertBtn convBtn;
	private TargetFldrSlctr tgSlct;
	private JButton open_og;
	private JButton open_tg;
	private Footer footer;
	private Tokenizer tokenizer;
	private Config config;
	//Test access Reader
	private ReadACCDB accReader;
	//Test DB Reader
	private ReadMDB mdbReader;

	//Layout for isbn Input
	private GroupLayout layout;
	private GroupLayout.ParallelGroup h_group;
	private GroupLayout.SequentialGroup v_group;
	
	// toggling debug mode i.e. red border lines of components
	private Boolean debugOn = false;

	private String isbn;
	// value isnt used, but gets set
	private String target_path;
	//ONIX database path
	public String mdb_path;
	//author database path
	public String accdb_path;
	
	// Constructor
	public Panel() {
		
		//GridBagLayout for the panel
		super(new GridBagLayout());
		config = new Config();

		//new layout
		GridBagConstraints constraints = new GridBagConstraints();
		
		convBtn = new ConvertBtn();
		tgSlct = new TargetFldrSlctr();
		
		//open origin button
		open_og = new JButton();
		open_og.setText("ISBN-Nummern angeben");
		open_og.setBorder(new LineBorder(Color.black, 1));
		//action listener for the button
		open_og.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open_origin();
			}
		});

		//open target button
		open_tg = new JButton();
		open_tg.setText("Zielordner öffnen");
		open_tg.setBorder(new LineBorder(Color.black, 1));
		open_tg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTgPath();
			}
		});
		
		footer = new Footer();
		
		//Test access Reader
		accReader = new ReadACCDB("Test DB");
		//Test MDB Reader
		mdbReader = new ReadMDB("Test MDB path");

		convBtn.setBorder(new LineBorder(Color.black, 1));
		convBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//debugging and development
				try {
				
					//open_origin();
					System.out.println("Converting...");
					//info set to "target", so we get the target string
					System.out.println(config.readCfg("target"));

					//other config.readCfg calls only for development
					//for production add instruction to check if the return value is
					//"0", which is the case, if the function call isn't performed correctly
					//this is the time for a warning pop-up to be implemented
					System.out.println(config.readCfg("mdbpath"));
					System.out.println(config.readCfg("accdbpath"));

				} catch(IOException | ParseException f) {
					
					System.out.println("No config file");
					
				}

			}
		});
		
		// Grid Layout for the main window
		//constraints.fill = GridBagConstraints.BOTH;
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.ipady = 40;
		constraints.ipadx = 60;
		
		//adding constraints to open_og
		add(open_og, constraints);
		
		constraints.gridx = 2;
		
		//adding constraints to open_tg
		add(open_tg, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 4;
		//constraints.gridheight = 2;
		constraints.ipady = 40;
		constraints.ipadx = 60;
		
		//adding constraints to convBtn
		add(convBtn, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 4;
		constraints.ipady = 50;
		
		//adding constraints to footer
		add(footer, constraints);
		
		
	}
	
	//visualizes the borders of the UI components
	public void debug() {
		
		//toggle debug 
		debugOn = !debugOn;
		
		if(debugOn) {
			
			//sets red borders for the components 
			convBtn.setBorder(new LineBorder(Color.red, 1));
			open_og.setBorder(new LineBorder(Color.red, 1));
			open_tg.setBorder(new LineBorder(Color.red, 1));
			footer.setBorder(new LineBorder(Color.red, 1));
		
		} else {
		
			//resets the borders to black
			convBtn.setBorder(new LineBorder(Color.black, 1));
			open_og.setBorder(new LineBorder(Color.black, 1));
			open_tg.setBorder(new LineBorder(Color.black, 1));
			footer.setBorder(null);
		
		}
		
	}
	
	//gets called when the "open origin" button will be clicked
	public void open_origin() {
		
		//debug
		System.out.println("Button is clicked");
		
		//creates new frame for ISBN-numbers input
		JFrame inputWin = new JFrame();
		inputWin.setTitle("Gebe die ISBNs an");
		inputWin.setSize(500, 300);
		inputWin.setResizable(false);
		
		//initializes the panel for the jframe
		JPanel panel = new JPanel();
		//Grouplayout for the panel
		layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
		panel.setLayout(layout);
		
		JLabel label = new JLabel("Geben Sie die ISBNs an (ISBN1-ISBN2): ");
		
		JTextField input = new JTextField(15);
		
		JButton accept = new JButton();
		accept.setText("Okay");
		
		//vertical and horizontal grouping of the components
		v_group = layout.createSequentialGroup();
		v_group.addGroup(layout.createParallelGroup()
				.addComponent(label).addComponent(input,20,20,20)
				);
		v_group.addGroup(layout.createParallelGroup()
				.addComponent(accept)
				);
		
		//horizontal grouping
		h_group = layout.createParallelGroup();
		h_group.addGroup(layout.createSequentialGroup()
				.addComponent(label).addComponent(input)
				);
		h_group.addGroup(layout.createSequentialGroup()
				.addComponent(accept)
				);
		
		//sets the groups for the layout
		layout.setVerticalGroup(v_group);
		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(h_group));
		
		//adds an event listener for the button
		accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				isbn = input.getText();

				// showIsbn doesnt work
				showIsbn(isbn);
				//initialize tokenizer with the input isbn
				tokenizer = new Tokenizer(isbn);
				
				// if the input of the ISBN numbers is right
				if(tokenizer.runTest()) {
					inputWin.dispose();
				} 
				// if the input of the ISBN numbers is wrong
				else {
					System.out.println("Falsche ISBN-Eingabe");
				}
				
			}
		});

		//add content
		inputWin.add(panel);
		show(inputWin);
		
	}
	
	//gets called when the "open target" button will be clicked
	public void open_target() {
		
		//opens the file-selection menu
		tgSlct.showOpenDialog(this);
	
	}
	
	//displays a window
	public void show(JFrame win) { 
		
		//shows the window
		win.setVisible(true);
	
	}
	
	//checks if a ISBN number is available
	public boolean checkNum(int num) {
		
		//feature not implemented yet, so the function will always return true
		return(true);
	
	}
	
	//shows the ISBN on the panel
	//doesnt work tho
	public void showIsbn(String isbn) {
		
		//textfield for the ISBN numbers
		JTextField isbnText = new JTextField(isbn);
		isbnText.setEditable(false);
		h_group.addGroup(layout.createSequentialGroup()
				.addComponent(isbnText));
	    v_group.addGroup(layout.createParallelGroup()
	    		.addComponent(isbnText));
	
	}

	//set the target path and makes changes to the
	//config file i.e. writes the target path to 
	//the config fiel
	public void setTgPath(){

		//show open_target context
		open_target();

		//FIX:
		//throws NullPointerException if the window is closed without the path being set
		if(tgSlct.getSelectedFile().getAbsolutePath() != null) {
			//target_path is the selected directory
			target_path = tgSlct.getSelectedFile().getAbsolutePath();
			//sets the target location in the config file
			config.setTgPath(target_path);
			//make the config file or change it
			config.makeCfg("target");
		}

	}

	//does basically the same as 'setTgPath()' but for DBs 
	public void setDbPaths(String db) {

		//show open_target context
		open_target();

		//implement the database UI
		//-> inspiration from setTgPath()
		if(tgSlct.getSelectedFile().getAbsolutePath() != null) {
			//check db param to find out, which db path is being set
			if(db == "mdb") {
				//set mdb path
				mdb_path = tgSlct.getSelectedFile().getAbsolutePath();
				config.setMdbPath(mdb_path);
				config.makeCfg("mdb");
			} else if(db == "accdb") {
				//set accdb path
				accdb_path = tgSlct.getSelectedFile().getAbsolutePath();
				config.setAccdbPath(accdb_path);
				config.makeCfg("accdb");
			} else {
				//no valid db name given 
				System.out.println("error, unknown 'db'");
			}
		}

	}
	
}
