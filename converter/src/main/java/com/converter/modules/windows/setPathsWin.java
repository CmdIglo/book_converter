package com.converter.modules.windows;

import javax.swing.*;

/**
 * GUI for configuration of database paths
 */

public class setPathsWin extends JFrame {
    
    public String mdbPath   = "";
    public String accdbPath = "";

    public setPathsWin() {
        this.getContentPane().setSize(200, 200);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setPaths() {

    }
}
