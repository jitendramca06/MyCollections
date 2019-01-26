package com.questions.java.designpattern.creational.singleton;

/**
 * Created by jitendra on 26 Feb, 2018
 */
public class BillPughSingleton {
    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
