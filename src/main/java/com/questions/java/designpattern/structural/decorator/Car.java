package com.questions.java.designpattern.structural.decorator;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
One class takes in another class, both of which extend the same abstract class, and adds functionality.


Decorator design pattern is used to modify the functionality of an object at runtime.
At the same time other instances of the same class will not be affected by this,
so individual object gets the modified behavior. Decorator design pattern is one of
the structural design pattern (such as Adapter Pattern, Bridge Pattern, Composite Pattern)
and uses abstract classes or interface with composition to implement.

Component Interface – The interface or abstract class defining
the methods that will be implemented. In our case Car will be the component interface.
 */
public interface Car {
    public void assemble();
}
