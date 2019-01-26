package com.questions.java.designpattern.sample.airtrafficcontroller;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class ATCMediator implements IATCMediator {
    public boolean land;
    private Flight flight;
    private Runway runway;

    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    public void registerFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isLandingOk() {
        return land;
    }

    @Override
    public void setLandingStatus(boolean status) {
        land = status;

    }
}
