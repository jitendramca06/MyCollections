package com.questions.java.designpattern.anotherexample.stauctural.flyweight;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class Rectangle implements Shape{
    private String colour;
    private int length;
    private int width;

    public Rectangle(String colour) {
        this.colour = colour;
    }

    @Override
    public void createShape() {
        System.out.println("================================");
        System.out.println("Creating Rectangle.................");
        System.out.println("Colour-" + colour);
        System.out.println("Length-" + length);
        System.out.println("Width-" + width);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
