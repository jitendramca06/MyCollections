package com.questions.java.designpattern.behavorial.template;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class HousingClient {
    public static void main(String[] args) {

        HouseTemplate houseType = new WoodenHouse();

        //using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();

        houseType.buildHouse();
    }
}
