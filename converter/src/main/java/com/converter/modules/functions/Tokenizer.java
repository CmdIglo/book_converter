
package com.converter.modules.functions;

/**
 * 
 * @author: Maxwell Leu
 * @version: 1.0.0
 * 
 * Input validation
 * 
 */

public class Tokenizer {
    
    //user input
    private String input;
    //test result
    public boolean testOut;
    private Integer isbnlen;

    // Constructor
    public Tokenizer(String inputString) {

        //set the input string
        this.input = inputString;
        isbnlen = 5;

    }

    // Run the validation process
    public boolean runTest() {

        //initialize the test-result variable
        testOut = true;
        //length = length of input string
        //has to be (isbn1-isbn2).length()
        //so 2 times the isbn length plus 1, because of the "-"
        Integer length = (isbnlen*2) +1 ; 

        //checks if the input is 11 characters long so that there is no arrayindexoutofrange exception
        if(this.input.length() == length) {

            int i = 0;

            //loop through the characters
            //while loop, so that i can be incremented by other values than 1
            while(i < isbnlen*2) {

                //first loop
                if(i == 0) {
                
                    //increment i by 4 so that a new character array of the first 5 characters of input can be initialized
                    i += isbnlen-1;
                    //the word of first 5 characters of input
                    String word = "";

                    //build the word
                    for(int j = 0; j <= i; j++) {
                        word = word + this.input.toCharArray()[j];
                    }

                    //checks if all 5 characters of word are integers
                    for(char chrctr : word.toCharArray()) {

                        if((Character.getNumericValue(chrctr) < 0) || (Character.getNumericValue(chrctr) > 9)) {
                            testOut = false;
                            return testOut;
                        }

                    }
            
                //second loop
                } else if(i == isbnlen-1) {

                    //increment i by 1 
                    i += 1;
                    //check the character at index i in input string
                    //the character at that index has to be a "-"
                    if(this.input.toCharArray()[i] != '-') {
                        testOut = false;
                        return testOut;
                    }

                //third loop (if other loops were succesful)
                } else {

                    //increment i by 5 so the last 5 characters of input can be checked
                    i += isbnlen;
                    //word for build-process
                    String word = "";

                    //build the word
                    for(int j = isbnlen+1; j <= i; j++) {
                        word = word + this.input.toCharArray()[j];
                    }

                    //check if the characters in word (last 5 characters of input string) are all integers
                    for(char chrctr : word.toCharArray()) {

                        if((Character.getNumericValue(chrctr) < 0) || (Character.getNumericValue(chrctr) > 9)) {
                            testOut = false;
                            return testOut;
                        }

                    }
                
                }
            
            } 
        //if the input string isn't 11 characters long
        } else {

            testOut = false;
            return testOut;

        }

        //if all checks are succesful return true
        return testOut;

    }

}
