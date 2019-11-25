package com.questions.java.constrictorcalling;

/**
 * @author Jitendra Kumar : 21/9/18
 */
public class Child1 extends SupperClass{
    String a = "b";

    public String getA() {
        return "b";
    }
    Child1() {
        System.out.println("Child1");
    }
}
