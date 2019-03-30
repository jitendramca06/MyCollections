package com.questions.java.thread.studentslibrary;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 30/3/19
 */
public class Student implements Runnable{
    private int id;
    private Book[] books;
    private Random random;
    private volatile boolean stop;
    private Set<Book> readBooks;

    Student(int id, Book[] books) {
        this.id = id;
        this.books = books;
        this.random = new Random();
        this.readBooks = new HashSet<>();
    }

    @Override
    public void run() {
        while (!stop) {
            Book book = books[random.nextInt(15)];
            try {
                if (book.getBook(this)) {
                    read(book);
                    book.returnBook(this);
                    readBooks.add(book);
                }else {
                    System.out.println("The book-" + book.getId() + " is not available...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void read(Book book) throws InterruptedException {
        System.out.println("Student-" + id + " is reading the book-" + book.getId());
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Student-" + id + " is completed reading the book-" + book.getId());
    }

    public int getId() {
        return id;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Set<Book> getReadBooks() {
        return readBooks;
    }
}
