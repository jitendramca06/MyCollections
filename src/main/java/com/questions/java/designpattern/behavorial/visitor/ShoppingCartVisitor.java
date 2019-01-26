package com.questions.java.designpattern.behavorial.visitor;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
