package com.questions.java.thread.threadssourcecodes.syncobjorref;

/**
 * @author Jitendra Kumar : 28/1/19
 */
public class ClassLevelAndObjLevelLock {

    private static int count = 0;
    private synchronized static void method1() {
        while (count < 50){
            System.out.println(Thread.currentThread().getName() + "==" + count++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void method2() {
        synchronized (this) {
            while (count < 50) {
                System.out.println(Thread.currentThread().getName() + "==" + count++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        ClassLevelAndObjLevelLock classLevelAndObjLevelLock = new ClassLevelAndObjLevelLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
                //classLevelAndObjLevelLock.method2();
            }
        }, "private synchronized static void method1()").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //ClassLevelAndObjLevelLock.method1();
                classLevelAndObjLevelLock.method2();
            }
        }, "private void method2()").start();
    }
}
