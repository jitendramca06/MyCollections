package com.questions.java.thread.threadssourcecodes.conditionwait.otherexample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jitendra Kumar : 24/1/19
 */
public class Producer implements Runnable {
    private Message message;

    public Producer(Message msg) {
        message = msg;
    }

    @Override
    public void run() {
        pusblishMessages();
    }

    private void pusblishMessages() {
        List<String> msgs = new ArrayList<String>();
        msgs.add("hello");
        msgs.add("hi");
        msgs.add("how");

        for (String msg : msgs) {
            message.publishMessage(msg);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
        }

        message.publishMessage("bye");
        message.setEndIt(true);
    }
}
