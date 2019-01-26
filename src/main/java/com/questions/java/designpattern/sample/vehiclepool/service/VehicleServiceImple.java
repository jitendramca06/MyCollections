package com.questions.java.designpattern.sample.vehiclepool.service;





import com.questions.java.designpattern.sample.vehiclepool.vehicle.Type;
import com.questions.java.designpattern.sample.vehiclepool.vehicle.Vehicle;

import java.util.*;

/**
 * @author Jitendra Kumar : 29/9/18
 */
public class VehicleServiceImple implements VehicleService{
    Map<String, Map<Type, List<Vehicle>>> vehicleMap = new HashMap<String, Map<Type, List<Vehicle>>>();
    List<String> timeSlot = new ArrayList<String>(Arrays.asList("00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
            "06-07", "07-08", "08-09", "09-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19",
            "19-20", "20-21", "21-22", "22-23", "23-00"));

    public void addVehicle(Type type, Vehicle vehicle) {
        for (String s : timeSlot) {
            Map<Type, List<Vehicle>> map = vehicleMap.get(s);
            List<Vehicle> vehicles = null;
            if (map == null) {
                map = new HashMap<Type, List<Vehicle>>();
                vehicles = new ArrayList<Vehicle>();
            } else {
                vehicles = map.get(type);
                if (vehicles == null) vehicles = new ArrayList<Vehicle>();
            }
            vehicles.add(vehicle);
            map.put(type, vehicles);
            vehicleMap.put(s, map);
        }
    }

    public int totalAvailableVehicle(String time, Type type) {
        Map<Type, List<Vehicle>> map = vehicleMap.get(time);
        if (map == null) return 0;
        return map.get(type).size();
    }

    public Vehicle getVehicle(String time, Type type) {
        if (totalAvailableVehicle(time, type) > 0) return vehicleMap.get(time).get(type).remove(0);
        return null;
    }

    public void cancelBooking(String time, Type type, Vehicle vehicle) {
        vehicleMap.get(time).get(type).add(vehicle);
    }
}
