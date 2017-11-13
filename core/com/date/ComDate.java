/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static app.config.Constants.*;

/**
 *
 * @author Ryno Laptop
 */
public class ComDate {
    //----------------------------------------------------------------------------------------
    /**
     * returns the current date
     * @return 
     */
    public static String getDate(){
        return getDate(new Date(), DATETIME);
    }
    //----------------------------------------------------------------------------------------
    /**
     * returns the current date formatted
     * @param format
     * @return 
     */
    public static String getDate(String format){
        if(format== null){ format = DATETIME; } 
        return getDate(new Date(), format== null ? DATETIME : format);
    }
    //----------------------------------------------------------------------------------------
    /**
     * returns the current date formatted
     * @param date
     * @return 
     */
    public static String getDate(Date date){
        return getDate(date, DATETIME);
    }
    //----------------------------------------------------------------------------------------
    /**
     * returns a date that is formatted to a certain format
     * @param date
     * @param format
     * @return 
     */
    public static String getDate(Date date, String format){
        if(format== null){
            format = DATETIME;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        String currentDate = dateFormat.format(date); //2014/08/06 15:59:48
        
        return currentDate;
    }
}
