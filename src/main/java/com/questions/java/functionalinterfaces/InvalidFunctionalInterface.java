package com.questions.java.functionalinterfaces;

/**
 * Created by jitendra on 13 Mar, 2018
 */

interface Doable extends Sayable{
    // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface
    //A functional interface can extends another interface only when it does not have any abstract method.
    void doIt();
}

public class InvalidFunctionalInterface  {
}
