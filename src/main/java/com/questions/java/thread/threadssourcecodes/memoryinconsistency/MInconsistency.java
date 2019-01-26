package com.questions.java.thread.threadssourcecodes.memoryinconsistency;

/**
 * @author Jitendra Kumar : 28/9/18
 */
public class MInconsistency {
    private static boolean flag;
    public static void main(String[] args) {
        new Thread(() -> {
            while (!flag) {
                System.out.println("First");
            }

            while (flag) {
                System.out.println("Second");
            }
        }).start();

        try {
            Thread.sleep(10);
            flag = !flag;
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = !flag;
    }
}
