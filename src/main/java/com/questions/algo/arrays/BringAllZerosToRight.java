package com.questions.algo.arrays;

import com.questions.java.comparablecomparator.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jitendra Kumar : 14/6/19
 */
public class BringAllZerosToRight {

    private static void zerosToRight(Integer[] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o2 == 0) return -1;
            else if (o1 == 0) return 1;
            return 0;
        });
    }

    private static void zerosToRight1(Integer[] arr) {
        int pre = 0;
        int next = 0;
        for (Integer a : arr) {
            if (arr[next] != 0) {
                arr[pre] = arr[next];
                arr[next] = 0;
                pre++;
                next++;
            } else next++;
        }
    }

    static boolean contains(String s, String p1) {
        String p = new String(p1);
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++) {
            int index = p.indexOf(chars[i]);
            if(index >= 0) p = p.substring(0, index) + p.substring(index+1);
        }
        return p.length() ==0;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0, 0, 0, 1, 0 ,2, 0, 3, 5};
        zerosToRight(arr);
        for (Integer a : arr) {
            System.out.print(a);
            System.out.print( " ");
        }

        System.out.println();
        arr = new Integer[]{0, 0, 0, 1, 0 ,2, 0, 3, 5};
        zerosToRight1(arr);
        for (Integer a : arr) {
            System.out.print(a);
            System.out.print( " ");
        }

        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);

        System.out.println(todayMidnight.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(tomorrowMidnight.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        now.add(Calendar.DATE, 1);
        System.out.println(now.getTime());

        String s = "abcdagf";
        int index = s.indexOf("a");
        s = s.substring(0 , index) + s.substring(index+1);
        System.out.println("[x]" + s);
        System.out.println(" [x] Sent '" + s + "'");

        System.out.println(contains("bab", "a"));

        int j = 0;
        for (int i = 0; i < 100; i++)
            j = j++;
        System.out.println(j);

    }
}
