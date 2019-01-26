package com.questions.java.designpattern.sample.airtrafficcontroller;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class SampleApp {
    public static void main(String args[]) {

        IATCMediator atcMediator = new ATCMediator();
        Flight sparrow101 = new Flight(atcMediator);
        Runway mainRunway = new Runway(atcMediator);
        atcMediator.registerFlight(sparrow101);
        atcMediator.registerRunway(mainRunway);
        sparrow101.getReady();
        mainRunway.land();
        sparrow101.land();
    }
}
