package com.questions.java.immutable;

/**
 * Created by jitendra on 12 Mar, 2018
 */

/*
To create immutable class in java, you have to do following steps.

1. Declare the class as final so it can’t be extended.
2. Make all fields private so that direct access is not allowed.
3. Don’t provide setter methods for variables
4. Make all mutable fields final so that it’s value can be assigned only once.
5. Initialize all the fields via a constructor performing deep copy.
6. Perform cloning of objects in the getter methods to return a copy rather than returning the
actual object reference.
 */
public final class FinalClassExample {
    private final int id;
    private final String name;

    FinalClassExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        FinalClassExample obj = new FinalClassExample(1, "Jitendra");
        System.out.println("Id:" + obj.getId() + ", Name:" + obj.getName());
        obj = new FinalClassExample(2, "Jitendra");
        System.out.println("Id:" + obj.getId() + ", Name:" + obj.getName());
    }
}
