package com.questions.java.stringop;

/**
 * Created by jitendra on 14 Mar, 2018
 */
public class StringConstantPool {
    public static void main(String[] args) {
        /*
        'Hello' would be created in string constant pool
         */
        String s = "Constant";
        String s1 = "Constant";
        String s2 = "Constant";
        String s3 = "Constant";
        String s4 = "Constant";

        /*
        'Hello' would not be created in string constant pool. 'Hello' will be
        available in heap memory.
         */
        String s5 = new String("Constant");
        String s6 = new String("Constant");
        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s == s5);
        System.out.println(s6 == s5);

    }
}
