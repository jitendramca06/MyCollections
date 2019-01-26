package com.questions.java.designpattern.anotherexample.stauctural.composite;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class SampleApp {
    public static void main(String[] args) {
        Block block1 = new Block();
        Block block2 = new Block();
        Block block3 = new Block();

        Structure structure1 = new Structure();
        Structure structure2 = new Structure();
        Structure structure3 = new Structure();

        structure1.add(block1);
        structure1.add(block2);
        structure2.add(block3);
        structure3.add(structure1);
        structure3.add(structure2);
        structure3.assemble();
    }
}
