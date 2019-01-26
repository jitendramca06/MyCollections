package com.questions.java.designpattern.structural.proxy;

/**
 * Created by jitendra on 27 Feb, 2018
 */
/*

The definition itself is very clear and proxy design pattern is used when we want to provide
controlled access of a functionality.

Let’s say we have a class that can run some command on the system. Now if we are using it,
its fine but if we want to give this program to a client application, it can have severe
issues because client program can issue command to delete some system files or change some
settings that you don’t want.
 */
public interface CommandExecutor {
    public void runCommand(String cmd) throws Exception;
}
