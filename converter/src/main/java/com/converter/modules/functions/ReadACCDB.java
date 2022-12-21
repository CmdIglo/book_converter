package com.converter.modules.functions;

import java.sql.*;
import javax.sql.*;

/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * Reader for Access DB data
 */

public class ReadACCDB {

    private String dbPath;

    /**
     * Constructor takes the database path as an argument
     * @param path: the path of the database
     */
    public ReadACCDB(String path) {

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
