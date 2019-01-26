package com.questions.java.designpattern.creational.abstractfactory;

/**
 * Created by jitendra on 26 Feb, 2018
 */

/*
An abstract factory has sets of methods to make families of various objects.

In Abstract Factory pattern,
we get rid of if-else block and have a factory class for each sub-class.
Then an Abstract Factory class that will return the sub-class based on the input factory class.
At first it seems confusing but once you see the implementation,
its really easy to grasp and understand the minor difference between Factory and Abstract Factory pattern.
 */
public abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}
