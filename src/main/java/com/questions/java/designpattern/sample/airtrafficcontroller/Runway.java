package com.questions.java.designpattern.sample.airtrafficcontroller;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class Runway implements Command {
    private IATCMediator atcMediator;

    public Runway(IATCMediator atcMediator) {
        this.atcMediator = atcMediator;
    }

    @Override
    public void land() {
        System.out.println("Landing permission granted...");
        atcMediator.setLandingStatus(true);
    }
}
