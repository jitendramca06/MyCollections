package com.questions.algo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Jitendra Kumar : 31/1/19
 */
public class MaxPathInHashMap {
    private static int pathCount(Map<String, String> pathMap, String key, int[] count, List<String> isVisited) {
        String val = pathMap.get(key);
        if (val == null || isVisited.contains(key)) return count[0];
        count[0]++;
        isVisited.add(key);
        return pathCount(pathMap, val, count, isVisited);
    }

    private static void printUsage() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("get")
                    && Modifier.isPublic(method.getModifiers())) {
                Object value;
                try {
                    value = method.invoke(operatingSystemMXBean);
                } catch (Exception e) {
                    value = e;
                } // try
                System.out.println(method.getName() + " = " + value);
            } // if
        } // for
    }

    public static void main(String[] args) {
        Map<String, String> pathMap = new HashMap<>();
        List<String> isVisited = new ArrayList<>();
        pathMap.put("A","B");
        pathMap.put("C","D");
        pathMap.put("B","P");
        pathMap.put("D","B");
        pathMap.put("P","Z");
        pathMap.put("Z","A");
        pathMap.put("E","F");
        //If loop is there then 'visited' will help to terminate the recursive call
        pathMap.put("TT","AA");
        pathMap.put("AA","TT");
        int max = 0;
        for (Map.Entry<String, String> m : pathMap.entrySet()) {
            isVisited = new ArrayList<>();
            int count = pathCount(pathMap, m.getKey(), new int[1], isVisited);
            System.out.println(m.getKey() + "==" + count);
            if (count > max)  max = count;
        }

        System.out.println(max);

        printUsage();
    }
}
