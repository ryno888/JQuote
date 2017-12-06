/*
 * Class 
 * @filename JLabelTimer 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 04 Dec 2017 * 
 */
package core.com.date;

import static core.com.date.ComDate.checkTime;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class JLableTimer extends JPanel {

    public JLableTimer(JLabel label) {
        new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar cal = new GregorianCalendar();
                int second = cal.get(Calendar.SECOND);
                int min = cal.get(Calendar.MINUTE);
                int hour = cal.get(Calendar.HOUR);
                String s =(checkTime(hour)+":"+checkTime(min)+":"+checkTime(second));
                label.setText(s);
            }
        }).start();
    }
}
