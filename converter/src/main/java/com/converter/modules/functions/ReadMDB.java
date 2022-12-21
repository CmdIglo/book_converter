package com.converter.modules.functions;

import java.sql.*;
import javax.sql.*;

/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * Reading mdb data
 */

public class ReadMDB {

    private String dbPath;

    /**
     * Constructor, takes Database path as argument
     * @param path: the database path
     */
    public ReadMDB(String path) {

        this.dbPath = path;

    }
    
    /**
     * returns the data, that was read from the database 
     * @param info: which info of book should be read from db
     * @return the info
     */
    public String read(String info) {

        return(this.dbPath);

    }

}
