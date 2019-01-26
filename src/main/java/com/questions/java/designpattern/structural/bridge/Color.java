package com.questions.java.designpattern.structural.bridge;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
An abstraction and implementation are in different class hierarchies.


When we have interface hierarchies in both interfaces as well as implementations,
then bridge design pattern is used to decouple the interfaces from
implementation and hiding the implementation details from the client programs.

Decouple an abstraction from its implementation so that the two can vary independently
 */
public interface Color {
    public void applyColor();
}
