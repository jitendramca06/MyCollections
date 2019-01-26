package com.questions.java.thread.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
The Exchanger Class provides a sort of rendezvous point for two threads, where the threads can exchange their
respective Objects with the other thread.
Whenever a thread arrives at the exchange point, it must wait for the other thread to arrive. When the
other pairing thread arrives the two threads proceed to exchange their objects.
The Exchanger Class also provides an overloaded version of the parameterless exchange() method,
exchange(V x, long timeout, TimeUnit unit). When the exchange method with time-out is used, the waiting
thread waits for the period passed as the argument(long timeout). If the corresponding pairing thread does
not arrive at the exchange point in that time, the waiting Thread throws a java.util.concurrent.TimeoutException.

In the above stack, we create an Exchanger Object of the type String. The Producer thread produces a
“filled queue” and exchanges it with the Consumer thread for an “empty queue”.(The filled and empty
queue mentioned here are just dummy string object, for the sake of brevity.). Similarly,
we can proceed to exchange any type of object between two threads, merely by changing the type parameter
of Exchanger instance.
 */
public class ExchangerExample {
    Exchanger exchanger = new Exchanger();

    public static void main(String[] args) {
        new ExchangerExample().start();
    }

    private void start() {
        new Thread(new Producer(), "Producer").start();
        new Thread(new Consumer(), "Consumer").start();
    }

    private class Producer implements Runnable {
        private String queue;

        @Override
        public void run() {
            try {
                //create tasks & fill the queue
                //exchange the full queue for a empty queue with Consumer
                queue = (String) exchanger.exchange("Ready Queue");
                System.out.println(Thread.currentThread().getName() + " now has " + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Consumer implements Runnable {

        private String queue;

        @Override
        public void run() {
            try {
                //do procesing & empty the queue
                //exchange the empty queue for a full queue with Producer
                queue = (String) exchanger.exchange("Empty Queue");
                System.out.println(Thread.currentThread().getName() + " now has " + queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
