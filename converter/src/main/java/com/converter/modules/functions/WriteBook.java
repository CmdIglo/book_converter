package com.converter.modules.functions;

/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * Makes new ONIX and saves it with/without EBook
 * 
 */

public class WriteBook {
    
    //target path, where the ONIX message and the book folder should be stored
    private String tgPath;

    //Constructor
    public WriteBook(String path) {

        this.tgPath = path;

    }

    //write the ONIX message and the book folder
    public void write(String target) {

    }

}
