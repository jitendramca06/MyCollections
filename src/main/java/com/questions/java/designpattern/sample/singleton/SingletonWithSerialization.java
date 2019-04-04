package com.questions.java.designpattern.sample.singleton;

import java.io.Serializable;

/**
 * @author Jitendra Kumar : 4/4/19
 */
public class SingletonWithSerialization implements Serializable {
    private static SingletonWithSerialization instance;

    private SingletonWithSerialization() {

    }

    public static SingletonWithSerialization getInstance() {
        if (instance == null) {
            synchronized (SingletonWithSerialization.class) {
                if (instance == null) {
                    instance = new SingletonWithSerialization();
                }
            }
        }
        return instance;
    }

    /**
     * This method will help to avoid creating new instance
     */
    private Object readResolve(){
        return instance;
    }
}
