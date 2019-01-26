package com.questions.java.functionalinterfaces;

/**
 * Created by jitendra on 13 Mar, 2018
 */
interface Doablee{
    default void doIt(){
        System.out.println("Do it now");
    }
}


interface Sayablee extends Doablee{
    void say(String msg);   // abstract method
}

public class FunctionalInterfaceExample implements Sayablee{
    @Override
    public void say(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
        fie.say("Hello there");
        fie.doIt();
    }
}
