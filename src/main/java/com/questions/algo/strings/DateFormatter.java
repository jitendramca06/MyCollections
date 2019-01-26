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
            /*System.out.println(format(1444725761000l,-25200000));
            System.out.println(parse("2015-10-13 01:42:41"));
            System.out.println(format(parse("2015-10-13 11:41:08"),-25200000));
            long s = new Date().getTime();
            System.out.println(s);
            System.out.println(getGMTTime(s));*/
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
        /*Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(time+timeOffset);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        return (fmt.format(calendar.getTime()));*/


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);

    }

    public static synchronized long parse(String time) {
        /*Calendar calendar = new GregorianCalendar();

        try {
            Calendar calendar2 = new GregorianCalendar();
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
            calendar2.setTime(fmt.parse(time+));
            return (calendar2.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;*/
       // return calendar.getTimeInMillis(); //add timezoneoffset passed as argument

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

    public static synchronized long parseDate(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        Date d = new Date();
        try {
            d = sf.parse(time);
        } catch (ParseException e) {

        }

        return d.getTime();

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

    /* This method will return the current date time stamp after subtracting the offset */
    public static String getCurrentDateTimeUsingOffset() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currDateTime = dateFormat.format(date);
        long tempLongdateTime = DateFormatter.parse(currDateTime) - Calendar.getInstance().getTimeZone().getRawOffset();
        String currDBDateTime = DateFormatter.format(Calendar.getInstance().getTimeZone().getRawOffset(), tempLongdateTime);
        return currDBDateTime;
    }

    public static String format(long time, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date d = new Date();
        d.setTime(time);
        return sf.format(d);

    }

    public static String converToDateFormat(String time, String inTimeFormat) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(inTimeFormat);
        long timemilli = sf.parse(time).getTime();
        return formatDate(timemilli);
    }

    public static String converToHourFormat(String time, String inTimeFormat) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(inTimeFormat);
        long timemilli = sf.parse(time).getTime();
        return formatHour(timemilli);
    }

    public static String converToMinuteFormat(String time, String inTimeFormat) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(inTimeFormat);
        long timemilli = sf.parse(time).getTime();
        return formatMinute(timemilli);
    }

    public static String removeZerofromdateTime(String time) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        d = sf.parse(time);
        return sf.format(d);
    }

    public static String getTimeOffSet(int timeOffsetInMs) {
        StringBuilder timeOffSet = new StringBuilder();
        if (timeOffsetInMs < 0)
            timeOffSet.append("-");
        else
            timeOffSet.append("+");
        int hours = Math.abs(timeOffsetInMs / (1000 * 60 * 60));
        int min = Math.abs(timeOffsetInMs / (1000 * 60)) - (hours * 60);
        timeOffSet.append(hours).append(":").append(min);
        return timeOffSet.toString();
    }


    public static String getTimeOffsetString(long timeoffsetinms) {
        String timeOffSet="+";
        if (timeoffsetinms < 0)
            timeOffSet = "-";

        long hours = Math.abs(timeoffsetinms / (1000 * 60 * 60));
        long min = Math.abs(timeoffsetinms / (1000 * 60)) - (hours * 60);
        timeOffSet += hours + ":" + (min<10 ? "0"+min:min);

        return "GMT"+timeOffSet;
    }

    public static void getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(System.currentTimeMillis()));
    }
}

