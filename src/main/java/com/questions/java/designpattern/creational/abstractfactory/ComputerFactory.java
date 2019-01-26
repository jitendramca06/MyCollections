package com.questions.java.designpattern.creational.abstractfactory;

/**
 * Created by jitendra on 26 Feb, 2018
 */
public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
