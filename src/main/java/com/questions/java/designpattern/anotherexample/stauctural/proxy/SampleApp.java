package com.questions.java.designpattern.anotherexample.stauctural.proxy;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class SampleApp {
    public static void main(String[] args) {
        ProxyFileOperation proxyFileOperation = new ProxyFileOperation();
        proxyFileOperation.addUserRole("Jitendra", "ADMIN");
        proxyFileOperation.addUserRole("Kumar", "USER");
        proxyFileOperation.addUserRole("Other", "NONUSER");
        proxyFileOperation.view("Jitendra", "File1");
        proxyFileOperation.edit("Jitendra", "File1");
        proxyFileOperation.view("Kumar", "File1");
        proxyFileOperation.edit("Kumar", "File1");
        proxyFileOperation.view("Other", "File1");
        proxyFileOperation.edit("Other", "File1");
    }
}
