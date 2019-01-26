package com.questions.java.designpattern.behavorial.template;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }
}
