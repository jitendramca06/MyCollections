package com.questions.java.designpattern.sample.vehiclepool.vehicle;

/**
 * @author Jitendra Kumar : 29/9/18
 */
public abstract class Vehicle {
    protected double basePrice;
    protected String vehicleNumber;
    protected String vehicleName;
    abstract public double getPrice();
    abstract public void setHikeOnBaseProce(double hikeOnBaseProce);
    public String vehicleName() {
        return vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
