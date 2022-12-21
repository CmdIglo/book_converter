
package com.converter.modules.functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//for writing and reading json
import org.json.simple.*;


/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * The Config-Reader class 
 * Reads and writes Config file
 * 
 */


public class Config {
    
    //new file directory
    private File newDir;
    //config file (writing)
    private File cfgFile;
    //config file (reading)
    private File cfgFile2;
    //writer for the config file
    private PrintWriter writer;
    //reader for the config file
    private Scanner reader;
    //target location as read from the config file
    private String location;
    //the path where the config file is to be stored
    private String path = "./.config/config.txt";

    //target location 
    public String targetLoc;

    /**
     * 
     * Constructor for the Config class
     * 
     */
    public Config() {

        //./config directory
        newDir = new File("./.config");
        //config file
        cfgFile = new File(path);

    }

    //set the location path
    public void setPath(String locString) {

        this.location = locString;
    
    }

    //makes a new config file to save the target location
    public void makeCfg() {
        
        //if the ".config" directory doesn't exist
        if (!newDir.exists()){
            //make the new directory
            newDir.mkdirs();

        } 
        
        //if the config file doesn't exist
        if(!cfgFile.exists()) {
            
            try {
                //creates new config file
                cfgFile.createNewFile();
            } catch(IOException e) {
                //lets hope this doesnt happen
                e.printStackTrace();
            }
        
        }
        
        try {
            
            //file-writer
            writer = new PrintWriter(cfgFile);
            //writes the location of the to-be-saved-files into the config file
            writer.println(this.location); 
            writer.close();
        
        } catch (FileNotFoundException f) {
            //lets REALLY hope this doesnt happen
            f.printStackTrace();
        }
    }

    //reads the config file
    public String readCfg() throws FileNotFoundException {

        //the file to be read
        cfgFile2 = new File(path);
        //file-reader
        reader = new Scanner(cfgFile2);
        //as there is only one line to be read by the reader, the nextline function is okay to be used
        targetLoc = reader.nextLine();
        //return the save-file location
        return(targetLoc);

    }

}
