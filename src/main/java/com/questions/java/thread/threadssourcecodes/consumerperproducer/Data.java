package com.questions.java.thread.threadssourcecodes.consumerperproducer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class Data {
    private AtomicInteger noOfIterationP;
    private AtomicInteger noOfIterationC;
    private int noOfThread;
    private List<Integer> dataList;
    private int dataSize;

    public Data(AtomicInteger noOfIterationP, int noOfThread, List<Integer> dataList, int dataSize, AtomicInteger noOfIterationC) {
        this.noOfIterationP = noOfIterationP;
        this.noOfThread = noOfThread;
        this.dataList = dataList;
        this.dataSize = dataSize;
        this.noOfIterationC = noOfIterationC;
    }

    public void produce(String thread, int threadId) {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (dataList) {
                    if (noOfIterationP.get() % noOfThread != threadId || !dataList.isEmpty()) dataList.wait();
                    else {
                        int count = noOfIterationP.getAndIncrement();
                        count = count * dataSize;
                        for (int i = 1 ; i <= dataSize ; i++) {
                            int result = count + i;
                            System.out.println(thread + "-" + result);
                            dataList.add(result);
                        }
                        dataList.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume(String thread, int threadId) {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (dataList) {
                    if (noOfIterationC.get() % noOfThread == threadId && dataList.size() == dataSize) {
                        for (int i = 0 ; i < dataList.size() ; i++)
                            System.out.println(thread + "-" + dataList.get(i));
                        dataList.clear();
                        noOfIterationC.getAndIncrement();
                        dataList.notifyAll();
                    }
                    else {
                        dataList.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
