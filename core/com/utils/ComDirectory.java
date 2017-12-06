/*
 * Class 
 * @filename ComDirectory 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 06 Dec 2017 * 
 */
package core.com.utils;

/**
 *
 * @author Ryno
 */
public class ComDirectory {
    //--------------------------------------------------------------------------
    public static String get_base_dir() {
        return System.getProperty("user.dir");
    }
    //--------------------------------------------------------------------------
}
