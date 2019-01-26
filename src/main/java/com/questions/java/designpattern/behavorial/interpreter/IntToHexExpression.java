package com.questions.java.designpattern.behavorial.interpreter;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class IntToHexExpression implements Expression {

    private int i;

    public IntToHexExpression(int c){
        this.i=c;
    }

    @Override
    public String interpret(InterpreterContext ic) {
        return ic.getHexadecimalFormat(i);
    }
}
