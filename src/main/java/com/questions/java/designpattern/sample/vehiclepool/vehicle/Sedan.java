package com.questions.java.designpattern.sample.vehiclepool.vehicle;

/**
 * @author Jitendra Kumar : 29/9/18
 */
public class Sedan extends Vehicle{
    private double hikeOnBaseProce;
    public double getPrice() {
        return (basePrice + (basePrice * hikeOnBaseProce)/100);
    }

    public void setHikeOnBaseProce(double hikeOnBaseProce) {
        this.hikeOnBaseProce = hikeOnBaseProce;
    }
}
