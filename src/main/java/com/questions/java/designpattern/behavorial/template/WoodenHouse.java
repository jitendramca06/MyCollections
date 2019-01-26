package com.questions.java.designpattern.behavorial.template;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class WoodenHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }
}
