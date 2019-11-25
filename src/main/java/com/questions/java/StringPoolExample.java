package com.questions.java;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @author Jitendra Kumar : 18/6/19
 * reference - http://java-performance.info/string-intern-in-java-6-7-8/
 *
 * 1. Stay away from String.intern() method on Java 6 due to a fixed size memory area (PermGen) used for JVM string pool storage.
 *
 * 2. Java 7 and 8 implement the string pool in the heap memory. It means that you are limited by the whole application memory for string pooling in Java 7 and 8.
 *
 * 3. Use -XX:StringTableSize JVM parameter in Java 7 and 8 to set the string pool map size. It is fixed, because it is implemented as a hash map with lists in the buckets. Approximate the number of distinct strings in your application (which you intend to intern) and set the pool size equal to some prime number close to this value multiplied by 2 (to reduce the likelihood of collisions). It will allow String.intern to run in the constant time and requires a rather small memory consumption per interned string (explicitly used Java WeakHashMap will consume 4-5 times more memory for the same task).
 *
 * 4. The default value of -XX:StringTableSize parameter is 1009 in Java 6 and Java 7 until Java7u40. It was increased to 60013 in Java 7u40 (same value is used in Java 8 as well).
 *
 * 5. If you are not sure about the string pool usage, try -XX:+PrintStringTableStatistics JVM argument. It will print you the string pool usage when your program terminates.
 */
public class StringPoolExample {
    private static final WeakHashMap<String, WeakReference<String>> s_manualCache =
            new WeakHashMap<String, WeakReference<String>>(100000);

    public static void main(String[] args) {
        //testStringPoolGarbageCollection();
        testLongLoop();
    }

    /**
     * Use this method to see where interned strings are stored
     * and how many of them can you fit for the given heap size.
     */
    private static void testLongLoop() {
        test(1000 * 1000 * 1000);
        //uncomment the following line to see the hand-written cache performance
        //testManual( 1000 * 1000 * 1000 );
    }

    /**
     * Use this method to check that not used interned strings are garbage collected.
     */
    private static void testStringPoolGarbageCollection() {
        //first method call - use it as a reference
        test(1000 * 1000);
        //we are going to clean the cache here.
        System.gc();
        //check the memory consumption and how long does it take to intern strings
        //in the second method call.
        test(1000 * 1000);
    }

    private static void test(final int cnt) {
        final List<String> lst = new ArrayList<String>(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; ++i) {
            final String str = "Very long test string, which tells you about something " +
                    "very-very important, definitely deserving to be interned #" + i;
//uncomment the following line to test dependency from string length
//            final String str = Integer.toString( i );
            lst.add(str.intern());
            if (i % 10000 == 0) {
                System.out.println(i + "; time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }
        System.out.println("Total length = " + lst.size());
    }

    private static String manualIntern(final String str) {
        final WeakReference<String> cached = s_manualCache.get(str);
        if (cached != null) {
            final String value = cached.get();
            if (value != null)
                return value;
        }
        s_manualCache.put(str, new WeakReference<String>(str));
        return str;
    }

    private static void testManual(final int cnt) {
        final List<String> lst = new ArrayList<String>(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; ++i) {
            final String str = "Very long test string, which tells you about something " +
                    "very-very important, definitely deserving to be interned #" + i;
            lst.add(manualIntern(str));
            if (i % 10000 == 0) {
                System.out.println(i + "; manual time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }
        System.out.println("Total length = " + lst.size());
    }
}
