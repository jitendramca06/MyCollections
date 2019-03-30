package com.questions.java.thread.studentslibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 30/3/19
 * Book-0 can be held by only one student at a time
 * Book-1 can be held by only one student at a time
 * and so on...
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Student[] students = new Student[5];
        Book[] books = new Book[15];
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0 ; i < books.length ; i++) {
            books[i] = new Book(i+1);
        }

        for (int i = 0 ; i < students.length ; i++) {
            students[i] = new Student(i+1, books);
            service.execute(students[i]);
        }

        TimeUnit.MILLISECONDS.sleep(10*1000);
        for (Student student : students) {
            student.setStop(true);
        }
        service.shutdown();
        if (!service.isTerminated()) {
            service.awaitTermination(5000, TimeUnit.MILLISECONDS);
        }

        System.out.println("Read books=================================");
        for (Student student : students) {
            System.out.print("Read books by student-" + student.getId() + "==");
            System.out.println(student.getReadBooks());
        }
    }
}
