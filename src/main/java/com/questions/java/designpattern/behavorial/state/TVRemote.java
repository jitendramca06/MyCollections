package com.questions.java.designpattern.behavorial.state;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class TVRemote {
    public static void main(String[] args) {
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setState(tvStartState);
        context.doAction();


        context.setState(tvStopState);
        context.doAction();

    }
}
