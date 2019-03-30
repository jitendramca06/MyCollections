package com.questions.java.thread.exchanger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * @author Jitendra Kumar : 30/3/19
 */
class Consumer implements Runnable{
    Exchanger<Map<String, String>> exchanger;
    Map<String, String> bucket = new HashMap<>();

    Consumer(Exchanger<Map<String, String>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!bucket.isEmpty()) {
                    System.out.println("Consumer consuming the data===================");
                    for (Map.Entry<String, String> map : bucket.entrySet()) {
                        System.out.println("Key-" + map.getKey() + " Value-" + map.getValue());
                    }
                    bucket.clear();
                }
                bucket = exchanger.exchange(bucket);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    Exchanger<Map<String, String>> exchanger;
    Map<String, String> bucket = new HashMap<>();

    Producer(Exchanger<Map<String, String>> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            while (true) {
                bucket.put("A", "A1");
                bucket.put("B", "B1");
                bucket.put("C", "C1");
                bucket.put("D", "D1");
                bucket.put("E", "E1");
                System.out.println("Data have been produced===================");
                bucket = exchanger.exchange(bucket);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConsumerProducer {
    public static void main(String[] args) {
        Exchanger<Map<String, String>> exchanger = new Exchanger<>();
        new Thread(new Producer(exchanger)).start();
        new Thread(new Consumer(exchanger)).start();
    }
}
