package com.converter.modules.functions;

/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * Makes new ONIX message and saves it with/without EBook
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
        //ONIX header
        System.out.println("<?xml version = ''1.0'' encoding = ''UTF-8''?>");
        System.out.println("<!DOCTYPE ONIXmessage SYSTEM ''https://www.editeur.org/onix/2.1/short/onix-international.dtd''>");
        System.out.println("<ONIXmessage  release=''2.1''>");
        System.out.println("<header>");
        System.out.println("<m174>Verlag Dr. Kovac</m174>");
        System.out.println("<m175>censored</m175>");
        System.out.println("<m283>info@verlagdrkovac.de</m283>");
        System.out.println("<m182>ONIX creation date</m182>");
        System.out.println("</header>");
    }

}
