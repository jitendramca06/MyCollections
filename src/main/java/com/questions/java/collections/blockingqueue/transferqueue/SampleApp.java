package com.questions.java.collections.blockingqueue.transferqueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class SampleApp {
    public static void main(String[] args) {
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        Data data = new Data(transferQueue);

        new Thread(()-> data.producer(), "Producer-1").start();
        new Thread(()-> data.consumer(), "Consumer-1").start();
        new Thread(()-> data.producer(), "Producer-1").start();
        new Thread(()-> data.consumer(), "Consumer-1").start();
    }
}
