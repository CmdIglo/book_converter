
package com.converter.modules.functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

//for writing and reading json
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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
    //writer for the config file
    private PrintWriter writer;
    //target location as read from the config file
    private String location;
    //the path where the config file is to be stored
    private String path = "./.config/config.json";
    //json object for json file
    private JSONObject obj;
    //json parser
    private JSONParser parser;
    //json object as output
    private JSONObject output;  

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
        //json object (input)
        obj = new JSONObject();
        //json parser
        parser = new JSONParser();

    }

    //set the location path
    public void setPath(String locString) {

        //target location
        this.location = locString;
    
    }

    /**
     * makes a new config file to save the target location
     * 
     * @param tgpath    : target folder path
     * @param mdbpath   : mdb path
     * @param accdbpath : accdb path
     */
    public void makeCfg(String tgpath, String mdbpath, String accdbpath) {
        
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
            obj.put("target_path", this.location);
            //writes the json data to the config file
            writer.println(obj.toJSONString());
            //close writer
            writer.close();
        
        } catch (FileNotFoundException f) {
            //lets REALLY hope this doesnt happen
            f.printStackTrace();
        }
    }

    /**
     * reads the config file
     * 
     * @param info              : requested info 
     * @return                  : info that's been requested
     * @throws IOException
     * @throws ParseException
     */
    public String readCfg(String info) throws IOException, ParseException {

        //catching exceptions is overrated
        try(Reader reader = new FileReader(path)){

            //json output read from config file
            output = (JSONObject) parser.parse(reader);
            //return the "target_path" value
            return (String) (output.get("target_path"));

        } 

        /*

        Old version (no json, plain text)

        //the file to be read
        cfgFile2 = new File(path);
        //file-reader
        reader = new Scanner(cfgFile2);
        //as there is only one line to be read by the reader, the nextline function is okay to be used
        targetLoc = reader.nextLine();
        //return the save-file location
        return(targetLoc);
         */

    }

}
