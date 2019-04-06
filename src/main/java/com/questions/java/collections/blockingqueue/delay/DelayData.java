package com.questions.java.collections.blockingqueue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class DelayData implements Delayed {
    private String data;
    private long expiryTime;

    public DelayData(String data, long expiryTime) {
       this.data = data;
       this.expiryTime = System.currentTimeMillis() + expiryTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = expiryTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (expiryTime < ((DelayData)o).expiryTime) return -1;
        else if (expiryTime > ((DelayData)o).expiryTime) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return ("Data-" + data + ",expiry-" + expiryTime);
    }
}
