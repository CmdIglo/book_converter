package com.converter.modules.Classes;

/**
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * A Book Class, that basically serves as an enum
 * of all the properties a book has for easier info
 * processing for the whole conversion/creation
 * process of the onix messages
 */

public class Book {
    
    //Properties of Book Class Instances 

    //Anzahl Seiten
    public String pages;
    //Art der Arbeit
    public String type;
    //Band Nummer in Schriftenreihe
    public String numInSrs;
    //Breite
    public String width;
    //Druckerei
    public String press;
    //Erscheinungsdatum
    public String date;
    //Hochschulort
    public String place;
    //Hochschule
    public String college;
    //ID Eindeutig (?)
    public String ide;
    //ISBN10
    public String isbn10;
    //ISBN13
    public String isbn13;
    //Jahr der Prüfung
    public String year;
    //Preis
    public String price;
    //Schlagworte
    public String keywords;
    //Schriftenreihe
    public String series;
    //Titelnummer
    public String titleNum;
    //Titel
    public String title;
    //Universität
    public String uni;
    //Verfasser/Herausgeber
    public String publisher;
    //Zielgruppe
    public String tgtGrp;

    //Constructor
    public Book() {

    }

    //Getters and Setters
    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPages() {
        return(this.pages);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return(this.type);
    }
    public void setNumInSrs(String numSrs) {
        this.numInSrs = numSrs;
    }

    public String getNumInSrs() {
        return(this.numInSrs);
    }
    public void setWidth(String width) {
        this.width = width;
    }

    public String getWidth() {
        return(this.width);
    }
    public void setPress(String press) {
        this.press = press;
    }

    public String getPress() {
        return(this.press);
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return(this.date);
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return(this.place);
    }
    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollege() {
        return(this.college);
    }
    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getIde() {
        return(this.ide);
    }
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn10() {
        return(this.isbn10);
    }
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn13() {
        return(this.isbn13);
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return(this.year);
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return(this.price);
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getKeywords() {
        return(this.keywords);
    }
    public void setSeries(String series) {
        this.series = series;
    }

    public String getSeries() {
        return(this.series);
    }
    public void setTitleNum(String titlenum) {
        this.titleNum = titlenum;
    }

    public String getTitleNum() {
        return(this.titleNum);
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return(this.title);
    }
    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getUni() {
        return(this.uni);
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return(this.publisher);
    }
    public void setTgtGrp(String tgtgr) {
        this.tgtGrp = tgtgr;
    }

    public String getTgtGrp() {
        return(this.tgtGrp);
    }


}
