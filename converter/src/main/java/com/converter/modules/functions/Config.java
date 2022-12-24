
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
    private String tglocation = null;     //setting standard values to 'null', so that no errors turn up      
    //ONIX database path
    private String mdblocation = null;    //-"-
    //author database path
    private String accdblocation = null;  //-"-
    //the path where the config file with target location path is stored
    private String path = "./.config/target.json";
    //the path where the config file with mdb location path is stored
    private String mcPath = "./.config/mdb.json";
    //the path where the config file with accdb location path is stored
    private String acPath = "./.config/accdb.json";
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
        //TODO: construct new File based on the info that needs to be stored -> add params somewhere
        //config file
        cfgFile = new File(path);
        //json object (input)
        obj = new JSONObject();
        //json parser
        parser = new JSONParser();

    }

    //set the target location path
    public void setTgPath(String locString) {

        //target location
        this.tglocation = locString;
    
    }

    //set the ONIX database location path
    public void setMdbPath(String locString) {

        //ONIX db location
        this.mdblocation = locString;

    }

    //set the author db location path
    public void setAccdbPath(String locString) {

        //set the author db path
        this.accdblocation = locString;

    }

    /**
     * makes a new config file to save the target location
     * TODO: add param to set the info that should be stored -> so based on what path should be set, the 
     *       function makes a new directory and file with the corresponding name and value
     * 
     * @param path : determines, which path is being set, and makes config file based on its value
     */
    public void makeCfg(String path) {
        
        //if the path param is "target"
        if(path == "target" && this.tglocation != null) {
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
                obj.put("target_path", this.tglocation);
                //writes the json data to the config file
                writer.println(obj.toJSONString());
                //close writer
                writer.close();
            
            } catch (FileNotFoundException f) {
                //lets REALLY hope this doesnt happen
                f.printStackTrace();
            }
        } else {
            //checks which database path is being set
            if(path == "mdb" && this.mdblocation != null) {
                
                System.out.println("Database paths feature not implemented yet");
            
            } else if(path == "accdb" && this.accdblocation != null) {
            
                System.out.println("Database paths feature not implemented yet");
            
            }
        }
    }

    /**
     * reads the config file
     * 
     * @param info              : what info is requested 
     * @return                  : info that's been requested
     * @throws IOException
     * @throws ParseException
     */
    public String readCfg(String info) throws IOException, ParseException {

        //checking the info param 
        if(info == "target") {
        
            //catching exceptions is overrated
            try(Reader reader = new FileReader(path)){

                //json output read from config file
                output = (JSONObject) parser.parse(reader);
                //return the "target_path" value
                return (String) (output.get("target_path"));

            } 
        
        } else if(info == "mdbpath" || info == "accdbpath") {
        
            return("Returning database paths");
        
        } else {

            return("No such config file");
        
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
