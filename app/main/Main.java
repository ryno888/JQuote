/*
 * Class 
 * @filename QuoteAppMySQL 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date Nov 11, 2017 * 
 */
package app.main;

import app.config.Setup;
import app.ui.MainPanel;

/**
 *
 * @author Ryno Laptop
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
		MainPanel main = new MainPanel();
		main.setTitle(Setup.SYSTEM_NAME);
		main.setVisible(true);
    }
    
}
