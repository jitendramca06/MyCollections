package com.questions.java.oops;

/**
 * @author Jitendra Kumar : 5/2/19
 *
 * The process by which one class acquires the properties(data members) and functionalities(methods) of another class is called inheritance. The aim of inheritance is to provide the reusability of code so that a class has to write only the unique features and rest of the common properties and functionalities can be extended from the another class
 *
 * Inheritance is a process of defining a new class based on an existing class by extending its common data members and methods.
 * Inheritance allows us to reuse of code, it improves reusability in your java application.
 * Note: The biggest advantage of Inheritance is that the code that is already present in base class need not be rewritten in the child class.
 */
public class InheritanceClass {
}

class Vehicle{
    public void start() {

    }
}

class FourWheeler extends Vehicle{

    //Here start method would be inherited
    public void noOfWheels() {
        System.out.println("Four");
    }
}

class TwoWheeler extends Vehicle{
    //Here start method would be inherited
    public void noOfWheels() {
        System.out.println("FouTwo");
    }
}
