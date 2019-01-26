package com.questions.algo.strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Jitendra Kumar : 18/12/18
 */
public class TimeDateConversion {
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss,SSS");
        dateFormat.setLenient(false);
        try {

           /* String[] allZones = TimeZone.getAvailableIDs();
            for (String s : allZones) {
                System.out.println(TimeZone.getTimeZone(s));
            }*/
            //dateFormat.setTimeZone(TimeZone.getTimeZone("GMT +4:30"));
            //int offset = TimeZone.getTimeZone("GMT +4:00").getRawOffset();
            //long foo = Long.parseLong("1545997165000");
            //System.out.println(dateFormat.format(foo));
            //System.out.println(dateFormat.format(foo));
            //Date date1 = new Date(foo - offset);
            //System.out.println(dateFormat.format(date1));

            Date date = dateFormat.parse(inDate.trim());
            System.out.println(date);

            long miisec = date.getTime();
            miisec = miisec + 120000;
            long startTime = miisec - 420000;
            System.out.println(dateFormat.format(miisec));
            System.out.println(dateFormat.format(startTime));

            Calendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(date.getTime());
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.println(fmt.format(calendar.getTime()));
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isValidDate("2018/01/08 12:34:49,430"));
        //System.out.println(isValidDate("dd/MMM/yyyy:HH:mm:ss"));
    }
}
