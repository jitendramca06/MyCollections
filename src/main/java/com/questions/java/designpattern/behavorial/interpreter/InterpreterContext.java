package com.questions.java.designpattern.behavorial.interpreter;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
he best stack of interpreter design pattern is java compiler that interprets the java source code
into byte code that is understandable by JVM. Google Translator is also an stack of interpreter
pattern where the input can be in any language and we can get the output interpreted in another language.

To implement interpreter pattern, we need to create Interpreter context engine that will do the interpretation work.
Then we need to create different Expression implementations that will consume the functionalities provided by the
interpreter context.

Finally we need to create the client that will take the input from user and decide which Expression to use and
then generate output for the user.

Let’s understand this with an stack where the user input will be of two forms – “<Number> in Binary” or
“<Number> in Hexadecimal.” Our interpreter client should return it in format “<Number> in Binary=
 <Number_Binary_String>” and “<Number> in Hexadecimal= <Number_Binary_String>” respectively.
 */
public class InterpreterContext {
    public String getBinaryFormat(int i){
        return Integer.toBinaryString(i);
    }

    public String getHexadecimalFormat(int i){
        return Integer.toHexString(i);
    }
}
