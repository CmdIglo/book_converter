package com.converter.modules.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * UI for input of onix/ebook database path
 * 
 */

public class accdbPath extends JFrame{
    
    //content panel for the window
    private JPanel contentPanel;
    //user input textfield
    private JTextField userInput;
    //confirm the input
    private JButton confirmInput;

    //Constructor
    public accdbPath(String title) {

        //inherit the properties of JFrame
        super(title);
        //initalizing the classes
        contentPanel = new JPanel();
        //making the textfield 20 characters long
        //not really necessary but nicer for the looks
        userInput = new JTextField(20);
        //the confirm input button
        confirmInput = new JButton();
        //setting the text in the button
        confirmInput.setText("Okay");

        //adding an action listener to the confirm input
        //button, that closes the window, if the user 
        //set the database path correctly
        confirmInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Set Author Database Path");
                //get the user input
                String path = userInput.getText();
                System.out.println(path);
                userInput.setText("");
                setPath("Test String");
            }  
        });

    }

    //generate and show the window
    public void showWin() {

        //making the content panel
        contentPanel.add(userInput);
        contentPanel.add(confirmInput);

        //building the actual window and making it visible
        this.add(contentPanel);
        this.pack();
        this.setVisible(true);
    
    }

    //add DB path to config file
    public void setPath(String path) {

        //add accDB path to config file

        System.out.println("Setting ACC Database");

    }

}
