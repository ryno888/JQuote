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

import app.app.AppSystem;
import app.config.Setup;
import app.ui.MainPanel;
import core.com.db.ComDBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ryno Laptop
 */
public class Main {
    //--------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        AppSystem.set_look_and_feel();
        
        Loader loader = new Loader();
        loader.setUndecorated(true);
        loader.setVisible(true);
        
        ComDBConnection comDBcon = new ComDBConnection();
        Connection con = comDBcon.getConnection();
        if(con.isValid(15)){
            MainPanel main = new MainPanel();
            main.setTitle(Setup.SYSTEM_NAME);
            loader.setVisible(false);
            main.setVisible(true);
        }
    }
    //--------------------------------------------------------------------------
//    public static void main(String[] args) throws SQLException {
//        System.out.println(ReadXMLFile.read());
//    }
    //--------------------------------------------------------------------------
    
}
