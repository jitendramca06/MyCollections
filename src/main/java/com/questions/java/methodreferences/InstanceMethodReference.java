package com.questions.java.methodreferences;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class InstanceMethodReference {
    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object
        // Referring non-static method using reference
        Sayable sayable = methodReference::saySomething;
        // Calling interface method
        sayable.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also
        // Calling interface method
        sayable2.say();

        Thread t2=new Thread(new InstanceMethodReference()::saySomething);
        t2.start();

        Thread t3=new Thread(methodReference::saySomething);
        t3.start();
    }
}
