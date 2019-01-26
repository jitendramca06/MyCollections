package com.questions.java.thread.TimeBasedStartAndStop;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jitendra Kumar : 11/1/19
 */
public class RunnerDaemon {
    private int startHour;
    private int startMinute;
    private int startSecond;

    private int endHour;
    private int endMinute;
    private int endSecond;
    private Map<String, AtomicBoolean> logTypes = new HashMap<>();

    public RunnerDaemon(int startHour, int startMinute, int startSecond, int endHour, int endMinute, int endSecond, String logType) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.startSecond = startSecond;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.endSecond = endSecond;
        logTypes.put(logType, new AtomicBoolean());
    }

    public void start(String logType) {
        startTimer(logType);
    }

    public void stop(String logType) {
        stopTimer(logType);
    }

    private void startTimer(final String logType) {
        final AtomicBoolean atomicBoolean = logTypes.get(logType);
        Date date = null;
        if (!atomicBoolean.get()) date = getStartTime();
        else date = getStopTime();
        final  Date finalDate = date;
        new Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                //TODO- base
                boolean flag = atomicBoolean.get();
                atomicBoolean.set(!flag);
                logTypes.put(logType, atomicBoolean);
                System.out.println(finalDate + " ==== " + logType + " = " + flag);
                startTimer(logType);
            }
        }, date);
    }

    private void stopTimer(String logType) {
        Date date = getStopTime();
        new Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                //TODO- base
                System.out.println(date + " ==== " + logType + " = is stpped processing.");
            }
        }, date);
    }


    private Date getStartTime() {
        Calendar startTime = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, startHour);
        startTime.set(Calendar.MINUTE, startMinute);
        startTime.set(Calendar.SECOND, startSecond);
        startTime.set(Calendar.MILLISECOND, 0);

        if (startTime.before(now) || startTime.equals(now)) {
            startTime.add(Calendar.MINUTE, 5);
            this.startHour = startTime.get(Calendar.HOUR_OF_DAY);
            this.startMinute = startTime.get(Calendar.MINUTE);
            this.startSecond = startTime.get(Calendar.SECOND);
        }

        return startTime.getTime();
    }

    private Date getStopTime() {
        Calendar startTime = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, endHour);
        startTime.set(Calendar.MINUTE, endMinute);
        startTime.set(Calendar.SECOND, endSecond);
        startTime.set(Calendar.MILLISECOND, 0);

        if (startTime.before(now) || startTime.equals(now)) {
            startTime.add(Calendar.MINUTE, 5);
            this.endHour = startTime.get(Calendar.HOUR_OF_DAY);
            this.endMinute = startTime.get(Calendar.MINUTE);
            this.endSecond = startTime.get(Calendar.SECOND);
        }

        return startTime.getTime();
    }

    public static Calendar getCalender(int hour, int min, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static void main(String[] args) {
        /*RunnerDaemon runnerDaemon = new RunnerDaemon(16, 45, 00, 16, 47, 00, "C24");
        runnerDaemon.start("C24");

        RunnerDaemon runnerDaemon1 = new RunnerDaemon(16, 45, 00, 16, 48, 00, "FI");
        runnerDaemon1.start("FI");

        RunnerDaemon runnerDaemon2 = new RunnerDaemon(16, 45, 00, 16, 49, 00, "LTM");
        runnerDaemon2.start("LTM");

        while (true) ;*/

        /*Calendar start = getCalender(15, 0, 0);
        Calendar stop = getCalender(8, 0, 0);
        if (stop.before(start)) {
            stop.add(Calendar.MINUTE, 120);
            System.out.println(stop.getTime());
        }
        else {
            System.out.println(start.getTime());
        }*/

        ConcurrentHashMap<String, ConcurrentHashMap<String, String>> mapMap = new ConcurrentHashMap<>();
        new Thread(() -> {
            int count  = 10;
            while (count--  >= 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
                map.put("AA", "A");
                map.put("BB", "B");
                map.put("CC", "C");
                mapMap.put("A",map);
                System.out.println(Thread.currentThread().getName() + "===" + mapMap);
            }
        }).start();

        new Thread(() -> {
            int count  = 10;
            while (count--  >= 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*Iterator<Map.Entry<String, Map<String, String>>> iterable = mapMap.entrySet().iterator();
                while (iterable.hasNext()) {
                    Map.Entry<String, Map<String, String>> stringMapEntry = iterable.next();
                    Iterator<Map.Entry<String, String>> entryIterator = stringMapEntry.getValue().entrySet().iterator();
                    while (entryIterator.hasNext()) {
                        Map.Entry<String, String> entry = entryIterator.next();
                        if (entry.getKey().equals("AA"))
                            entryIterator.remove();
                    }
                }*/
               for (ConcurrentHashMap.Entry<String, ConcurrentHashMap<String, String>> m : mapMap.entrySet()) {
                   ConcurrentHashMap<String, String> map = m.getValue();
                   for (ConcurrentHashMap.Entry<String, String> mm : map.entrySet()) {
                       map.remove(mm.getKey());
                   }
               }
                System.out.println(Thread.currentThread().getName() + "===" + mapMap);
            }
        }).start();

        while (true);
    }
}
