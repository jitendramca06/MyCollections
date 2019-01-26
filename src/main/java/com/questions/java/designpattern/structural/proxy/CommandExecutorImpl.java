package com.questions.java.designpattern.structural.proxy;

import java.io.IOException;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) throws IOException {
        //some heavy implementation
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
}
