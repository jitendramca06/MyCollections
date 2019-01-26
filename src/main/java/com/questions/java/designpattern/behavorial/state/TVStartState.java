package com.questions.java.designpattern.behavorial.state;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class TVStartState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }
}
