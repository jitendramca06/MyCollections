package com.questions.java.concurrentmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jitendra on 14 Mar, 2018
 */

/*
Why use Concurrent Hashmap-
We use ConcurrentHashMap when a high level of concurrency is required. But already SynchronizedMap is present
so what advantages does ConcurrentHashMap have over synchronized map.Both are thread safe.
The major advantage is in case of synchronizedMap every write operation acquires lock on entire
SynchronizedMap while in case of ConcurrentHashMap the lock is only on one of the segments.

As no concurrency level has been set explictity, the ConcurrentHashMap gets divided into 16 segments.
And each segment acts as an independent HashMap. During right operation the Lock is obtained on this
particular segment and not on the entire HashMap

1. Synchronization is at Object level
Synchronization is at segment level

2. A lock is obtained for read/write operation at object level
A lock is obtained for write operation at segment level

3. Concurrency level cannot be set for better optimization
Concurrency level can be set for better optimization

4. ConcurrentModification Exception is thrown if a thread tries to modify an existing SynchronizedMap which is being iterated
ConcurrentModification Exception is thrown if a thread tries to modify an existing ConcurrentHashMap which is being iterated

5. Since at a given time only a single Thread can modify the map and block other threads the performance is comparatively bad.
Multiple Threads can modify ConcurrentHashMap. Hence performance is much better.
 */
public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> conMap = new ConcurrentHashMap<>();
        MapHelper mapHelper1 = new MapHelper(conMap, "mapHelper1");
        MapHelper mapHelper2 = new MapHelper(conMap, "mapHelper2");
        MapHelper mapHelper3 = new MapHelper(conMap, "mapHelper3");
        MapHelper mapHelper4 = new MapHelper(conMap, "mapHelper4");
        MapHelper mapHelper5 = new MapHelper(conMap, "mapHelper5");
        MapHelper mapHelper6 = new MapHelper(conMap, "mapHelper6");
        MapHelper mapHelper7 = new MapHelper(conMap, "mapHelper7");
        MapHelper mapHelper8 = new MapHelper(conMap, "mapHelper8");

        for (Map.Entry<String, Integer> e : conMap.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

    }
}
