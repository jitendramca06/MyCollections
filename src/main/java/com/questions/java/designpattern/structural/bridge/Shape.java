package com.questions.java.designpattern.structural.bridge;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public abstract class Shape {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    public Shape(Color c){
        this.color=c;
    }

    abstract public void applyColor();
}
