package com.questions.java.constrictorcalling;

/**
 * @author Jitendra Kumar : 21/9/18
 */
public class SupperClass {
    String a = "a";
    SupperClass() {
        System.out.println("Supper Calss");
    }

    public String getA() {
        return "a";
    }

    protected void print() {
        System.out.println("Supper Print");
    }
}
