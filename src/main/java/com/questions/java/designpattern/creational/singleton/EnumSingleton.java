package com.questions.java.designpattern.creational.singleton;

/**
 * Created by jitendra on 26 Feb, 2018
 */
enum EnumSingleton {
    INSTANCE;

    public void doSomething(){
        System.out.println("Hello Singleton");
    }
}

class SingletonExample {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething();
    }
}
