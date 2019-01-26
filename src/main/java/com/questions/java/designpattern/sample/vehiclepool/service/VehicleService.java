package com.questions.java.designpattern.sample.vehiclepool.service;


import com.questions.java.designpattern.sample.vehiclepool.vehicle.Type;
import com.questions.java.designpattern.sample.vehiclepool.vehicle.Vehicle;

/**
 * @author Jitendra Kumar : 29/9/18
 */
public interface VehicleService {
    void addVehicle(Type type, Vehicle vehicle);
    int totalAvailableVehicle(String time, Type type);
    Vehicle getVehicle(String time, Type type);
    void cancelBooking(String time, Type type, Vehicle vehicle);
}
