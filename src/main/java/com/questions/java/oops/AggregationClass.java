package com.questions.java.oops;

/**
 * @author Jitendra Kumar : 5/2/19
 *
 * Aggregation is a special form of association. It is a relationship between two classes like association, however its a directional association, which means it is strictly a one way association. It represents a HAS-A relationship.
 */
public class AggregationClass {
}

class Address{
    String city;
    String state;
}

class Student{
    String name;
    Address address;
}

/**
 * The above example shows the Aggregation between Student and Address classes. You can see that in Student class I have declared a property of type Address to obtain student address. Its a typical example of Aggregation in Java.
 */
