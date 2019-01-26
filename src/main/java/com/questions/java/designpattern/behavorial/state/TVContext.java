package com.questions.java.designpattern.behavorial.state;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class TVContext implements State {

    private State tvState;

    public void setState(State state) {
        this.tvState=state;
    }

    /*public State getState() {
        return this.tvState;
    }*/

    @Override
    public void doAction() {
        this.tvState.doAction();
    }

}
