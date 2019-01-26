package com.questions.java.designpattern.behavorial.visitor;

/**
 * Created by jitendra on 28 Feb, 2018
 */

/*
Visitor (uses double-dispatch) Overview

One or more related classes have the same method, which calls a method specific for themselves in another class.

Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. With the help
of visitor pattern, we can move the operational logic from the objects to another class.

For stack, think of a Shopping cart where we can add different type of items (Elements). When we click on
checkout button, it calculates the total amount to be paid. Now we can have the calculation logic in item
classes or we can move out this logic to another class using visitor pattern. Let’s implement this in our
stack of visitor pattern.
 */
public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
