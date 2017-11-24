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
import core.com.html.ComHtmlBuilder;
import java.util.HashMap;

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
        
//        ComHtmlBuilder builder = new ComHtmlBuilder();
//        builder.label("Ryno", new HashMap<String, Object>(){{
//            this.put(".test", true);
//            this.put(".test2", true);
//            this.put("@test1", "test1");
//            this.put("@test2", "test2");
//        }});
//        System.out.println(builder.get_html());
        
        MainPanel main = new MainPanel();
        main.setTitle(Setup.SYSTEM_NAME);
        main.setVisible(true);
    }
    
}
