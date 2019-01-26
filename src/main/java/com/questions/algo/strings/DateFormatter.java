package com.questions.algo.strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * This Class foramts date into utility String
 *
 * @author Jitendra Kumar
 */
public class DateFormatter {

    /**
 * Common date formatter
 */

    public static void main(String a[]){
        try{
            getTime();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }

    public synchronized static String getGMTTime(long time) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(time);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        return (fmt.format(calendar.getTime()));
    }
    /**
     * This method formats time from long type to String type
     *
     * @param time
     * @return String
     */
    public synchronized static String format(long time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);
    }

    /**
     * This method formats from long to string data type and also adding time to timeOffset
     *
     * @param time
     * @return String
     */
    public synchronized static String format(long time, long timeOffset) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);

    }

    public static synchronized long parse(String time) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        try {
            d = sf.parse(time);
        } catch (ParseException e) {

        }

        return d.getTime();
    }

    public static synchronized long parse(String time, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);

        Date d = new Date();
        try {
            d = sf.parse(time);
        } catch (ParseException e) {

        }

        return d.getTime();

    }

    public synchronized static String formatDate(long time) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);

    }

    public synchronized static String formatHour(long time) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH");
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);

    }

    public static synchronized long parseHour(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH");

        Date d = new Date();
        try {
            d = sf.parse(time);
        } catch (ParseException e) {

        }

        return d.getTime();

    }

    public synchronized static String formatMinute(long time) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);

    }

    public static synchronized long parseMinute(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date d = new Date();
        try {
            d = sf.parse(time);
        } catch (ParseException e) {

        }

        return d.getTime();

    }

    public static String format(long time, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);

    }

    public static void getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(System.currentTimeMillis()));
    }
}

