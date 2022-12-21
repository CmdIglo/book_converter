package com.converter.modules.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * UI for input of ISBN len
 */

public class setIsbnWin extends JFrame{
    
    //content panel for the window
    private JPanel contentPanel;
    //user input textfield
    private JTextField userInput;
    //confirm the input
    private JButton confirmInput;

    //Constructor
    public setIsbnWin(String title) {

        //inherit the properties of JFrame
        super(title);
        //initalizing the classes
        contentPanel = new JPanel();
        //making the textfield 10 characters long
        //not really necessary but nicer for the looks
        userInput = new JTextField(10);
        //the confirm input button
        confirmInput = new JButton();
        //setting the text in the button
        confirmInput.setText("Okay");

        //adding an action listener to the confirm input
        //button, that closes the window, if the user 
        //set the length of isbn properly
        confirmInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Setze ISBN länge");
                //get the user input
                String len = userInput.getText();
                System.out.println(len);
                userInput.setText("");
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

}
