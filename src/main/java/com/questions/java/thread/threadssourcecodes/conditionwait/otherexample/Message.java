package com.questions.java.thread.threadssourcecodes.conditionwait.otherexample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jitendra Kumar : 24/1/19
 *
 *
 * Like threads communicate using wait(), notify() and notifyAll() methods of object when intrinsic lock is used to restrict access to a shared objects, Condition allows inter threads communication when external locks are used. Condition defines mechanism to suspend a thread until another thread notifies it. Using condition, deadlock issue can be avoided with external locks.
 *
 * Condition object is obtained by calling newCondition() methods on lock object, ReentrantLock or ReentrantReadWriteLock. Condition defines methods such as await(), signal() and signalAll() for waiting and notifying. Overloaded await() methods allows you to specify the duration of the wait. Method siganlAll() notifies all waiting threads.
 *
 *
 * Following example shows how to use condition object for communication between two threads when ReentrantLock is used to restrict access to share message object which contains methods to publish and view messages. If the last message is not consumed, publish-message thread waits using a condition object and calling awaits() on it. Similarly, if there is no new message, view-message thread waits using another condition object and calling awaits method on it.
 *
 * When publish-message thread sets new message, it will notify view-message thread by calling signal() on the condition object on which view-message thread is waiting. Similarly, when view-message thread consumes the message, it will notify publish-message thread by calling signal() method on the condition object on which publish-message thread is waiting.
 */
public class Message {
    final private Lock lock = new ReentrantLock();
    final private Condition producedMsg = lock.newCondition();
    final private Condition consumedMsg = lock.newCondition();

    private String message;
    private boolean messageState;
    private boolean endIt;

    public void viewMessage() {
        //lock
        lock.lock();
        try {
            //no new message wait for new message
            while (!messageState)
                producedMsg.await();

            System.out.println("Here is the latest message : " + message);
            messageState = false;
            //message consumed, notify waiting thread
            consumedMsg.signal();

        } catch (InterruptedException ie) {
            System.out.println("Thread interrupted - viewMessage");
        } finally {
            lock.unlock();
        }
    }

    public void publishMessage(String message) {
        lock.lock();
        try {
            //last message not consumed, wait for it be consumed
            while (messageState)
                consumedMsg.await();

            System.out.println("adding latest message ");
            this.message = message;
            messageState = true;
            //new message added, notify waiting thread
            producedMsg.signal();

        } catch (InterruptedException ie) {
            System.out.println("Thread interrupted - publishMessage");
        } finally {
            lock.unlock();
        }

    }

    public boolean isEndIt() {
        return endIt;
    }

    public void setEndIt(boolean endIt) {
        this.endIt = endIt;
    }
}
