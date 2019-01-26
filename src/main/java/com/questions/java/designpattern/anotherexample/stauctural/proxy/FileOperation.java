package com.questions.java.designpattern.anotherexample.stauctural.proxy;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public interface FileOperation {
    public void edit(String user, String file);
    public void view(String user, String file);
}
