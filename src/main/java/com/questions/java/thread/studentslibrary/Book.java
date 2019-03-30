package com.questions.java.thread.studentslibrary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jitendra Kumar : 30/3/19
 */
public class Book {
    private int id;
    private Lock lock;

    Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean getBook(Student student) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println("Student-" + student.getId() + " got book-" + id);
            return true;
        }
        return false;
    }

    public void returnBook(Student student) {
        lock.unlock();
        System.out.println("Student-" + student.getId() + " returned book-" + id);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book-" + id;
    }
}
