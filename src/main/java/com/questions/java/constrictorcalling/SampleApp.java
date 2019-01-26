package com.questions.java.constrictorcalling;

/**
 * @author Jitendra Kumar : 21/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        SupperClass c = new Child2();
        c.print();
        System.out.println("==========================");
        Child2 child2 = new Child2();
        child2.print();
    }
}
