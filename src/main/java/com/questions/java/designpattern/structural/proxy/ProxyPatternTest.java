package com.questions.java.designpattern.structural.proxy;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class ProxyPatternTest {
    public static void main(String[] args){
        CommandExecutor executor = new CommandExecutorProxy("jitendra", "wrong_pwd");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
        }

    }
}
