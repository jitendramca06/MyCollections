package com.questions.java.designpattern.sample.vehiclepool.sample;

import com.questions.java.designpattern.sample.vehiclepool.service.VehicleService;
import com.questions.java.designpattern.sample.vehiclepool.service.VehicleServiceImple;
import com.questions.java.designpattern.sample.vehiclepool.vehicle.*;

/**
 * @author Jitendra Kumar : 29/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleServiceImple();
        //initialise SUV vehicle
        for (int  i = 0 ; i < 1 ; i++) {
            Vehicle suv = new SUV();
            suv.setBasePrice(100);
            suv.setHikeOnBaseProce(10);
            suv.setVehicleName(Type.SUV.toString());
            suv.setVehicleNumber("1234" + i);
            vehicleService.addVehicle(Type.SUV, suv);
        }
        //initialise Sedan vehicle
        for (int  i = 0 ; i < 10 ; i++) {
            Vehicle sedan = new Sedan();
            sedan.setBasePrice(100);
            sedan.setHikeOnBaseProce(15);
            sedan.setVehicleName(Type.SEDAN.toString());
            sedan.setVehicleNumber("1234" + i);
            vehicleService.addVehicle(Type.SEDAN, sedan);
        }
        //initialise hatch vehicle
        for (int  i = 0 ; i < 10 ; i++) {
            Vehicle hatchback = new Hatchback();
            hatchback.setBasePrice(100);
            hatchback.setHikeOnBaseProce(20);
            hatchback.setVehicleName(Type.HATCHBACK.toString());
            hatchback.setVehicleNumber("1234" + i);
            vehicleService.addVehicle(Type.HATCHBACK, hatchback);
        }

        //Total SUV vehicle
        System.out.println(vehicleService.totalAvailableVehicle("00-01", Type.SUV));
        Vehicle vehicle = vehicleService.getVehicle("00-01", Type.SUV);
        if (vehicle == null) System.out.println("At Time-" + "00-01, " + Type.SUV + " vehicle is available in vehicle pool");
        else System.out.println(vehicle.getVehicleNumber() + "," + vehicle.getPrice());
        vehicleService.cancelBooking("00-01", Type.SUV, vehicle);
        Vehicle vehicle1 = vehicleService.getVehicle("00-01", Type.SUV);
        if (vehicle1 == null) System.out.println("At Time-" + "00-01, " + Type.SUV + " vehicle is available in vehicle pool");
        else System.out.println(vehicle1.getVehicleNumber() + "," + vehicle1.getPrice());
        Vehicle vehicle2 = vehicleService.getVehicle("01-02", Type.HATCHBACK);
        if (vehicle2 == null) System.out.println("At Time-" + "00-01, " + Type.HATCHBACK + " vehicle is available in vehicle pool");
        else System.out.println(vehicle2.getVehicleNumber() + "," + vehicle2.getPrice());
    }
}
