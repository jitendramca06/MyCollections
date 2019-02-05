package com.questions.java.oops;

/**
 * @author Jitendra Kumar : 5/2/19
 *
 * Association establishes relationship between two separate classes through their objects. The relationship can be one to one, One to many, many to one and many to many
 * Association refers to the relationship between multiple objects. It refers to how objects are related to each other and how they are using each other's functionality
 */
public class AssociationClass {
}

class Car{
    String name;
    int id;

    Car(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Driver extends Car{
    String driverName;
    Driver(String driverName, String name, int id) {
        super(name, id);
        this.driverName = driverName;
    }
}

/**
 * In the above example, there is a one to one relationship(Association) between two classes: CarClass and Driver. Both the classes represent two separate entities
 */
