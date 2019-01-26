package com.questions.java.designpattern.sample.airtrafficcontroller;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public interface IATCMediator {
    public void registerRunway(Runway runway);

    public void registerFlight(Flight flight);

    public boolean isLandingOk();

    public void setLandingStatus(boolean status);
}
