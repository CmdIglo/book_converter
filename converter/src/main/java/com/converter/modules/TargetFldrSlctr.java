
package com.converter.modules;
import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Maxwell
 * 
 * This is the target folder selector class
 *
 */

public class TargetFldrSlctr extends JFileChooser {

	//Constructor
	public TargetFldrSlctr() {
		
		//setting the File Selction Mode to only 
		//directories, as we dont want single files
		//to be chosen as target location
		this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
	}
	
}
