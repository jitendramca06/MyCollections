package com.questions.java.oops;

/**
 * @author Jitendra Kumar : 5/2/19
 *
 * Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through the methods of their current class. Therefore, it is also known as data hiding.
 *
 * 1. Variables of a class should be private.
 * 2. Provide public setter and getter methods to modify and view the variables values.
 */
public class EncapsulationClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
