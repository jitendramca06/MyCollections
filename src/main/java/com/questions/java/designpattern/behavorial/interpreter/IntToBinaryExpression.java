package com.questions.java.designpattern.behavorial.interpreter;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class IntToBinaryExpression implements Expression {

    private int i;

    public IntToBinaryExpression(int c){
        this.i=c;
    }
    @Override
    public String interpret(InterpreterContext ic) {
        return ic.getBinaryFormat(this.i);
    }
}
