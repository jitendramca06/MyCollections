package com.questions.java.oops;

/**
 * @author Jitendra Kumar : 5/2/19
 *
 * Polymorphism is one of the OOPs feature that allows us to perform a single action in different ways.
 * In other words, polymorphism allows you define one interface and have multiple implementations
 *
 * 1. Method Overloading in Java – This is an example of compile time (or static polymorphism)
 * 2. Method Overriding in Java – This is an example of runtime time (or dynamic polymorphism)
 * 3. Types of Polymorphism – Runtime and compile time
 */
public class PolymorphismClass {
}

/**
 * Runtime Polymorphism example
 */
class Animal{
    public void sound(){
        System.out.println("sound");
    }
}

class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("dog");
    }
}

/**
 * Compile time Polymorphism
 */
class Functions{
    public void method(int a){
        System.out.println(a);
    }

    public void method(int a, int b) {

    }
}