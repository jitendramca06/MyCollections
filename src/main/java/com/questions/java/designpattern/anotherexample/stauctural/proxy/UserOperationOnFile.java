package com.questions.java.designpattern.anotherexample.stauctural.proxy;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class UserOperationOnFile implements FileOperation{
    @Override
    public void edit(String user, String file) {
        System.out.println(user + " editing the " + file + "..........");
    }

    @Override
    public void view(String user, String file) {
        System.out.println(user + " viewing the " + file + "..........");
    }
}
