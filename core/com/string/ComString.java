/*
 * Class 
 * @filename UtilArray 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 25 Aug 2017 * 
 */
package core.com.string;

import java.text.DecimalFormat;

/**
 *
 * @author Ryno
 */
public class ComString {
    //--------------------------------------------------------------------------
    public static String ucwords(String sentence) {
        StringBuilder sb = new StringBuilder();

        for (CharSequence word: sentence.split(" "))
            sb.append(Character.toUpperCase(word.charAt(0))).append(word.subSequence(1, word.length())).append(" ");

        return sb.toString().trim();
    }
    //--------------------------------------------------------------------------
    public static String ucfirst(String sentence) {
        return String.valueOf(Character.toUpperCase(sentence.charAt(0))).concat(sentence.substring(1));
    }
    //--------------------------------------------------------------------------
    public static String format_currency(String value) {
        return format_currency(Double.parseDouble(value));
    }
    //--------------------------------------------------------------------------
    public static String format_currency(int value) {
        return format_currency(Double.parseDouble(String.valueOf(value)));
    }
    //--------------------------------------------------------------------------
    public static String format_currency(float value) {
        return format_currency(Double.parseDouble(String.valueOf(value)));
    }
    //--------------------------------------------------------------------------
    public static String format_currency(Double value) {
        DecimalFormat formatter = new DecimalFormat("R ###,###,##0.00");
        return formatter.format(value);
    }
    //--------------------------------------------------------------------------
    public static String pad(String str, int size, char padChar) {
        StringBuilder padded = new StringBuilder(str);
        while (padded.length() < size) {
            padded.append(padChar);
        }
        return padded.toString();
    }
    //--------------------------------------------------------------------------
}
