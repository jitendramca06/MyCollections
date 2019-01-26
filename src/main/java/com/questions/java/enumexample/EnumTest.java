package com.questions.java.enumexample;

/**
 * Created by jitendra on 20 Mar, 2018
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(ArithOperation.PLUS.apply(10, 20));
        System.out.println(ArithOperation.MINUS.apply(10,20));
        System.out.println(ArithOperation.DIV.apply(10, 20));
        System.out.println(ArithOperation.MUL.apply(10, 20));

        for (Planet p : Planet.values()) {
            System.out.println("****** "+ p.name() + " ******");
            System.out.println(p.getX());
            System.out.println(p.getY());
            System.out.println(p.getZ());
        }

        System.out.println(ArithOperation1.PLUS.apply(10, 20));

        for (ArithOperation2 p : ArithOperation2.values()) {
            System.out.printf("%f %s %f = %f%n",10d, p.toString(), 20d, p.apply(10, 20));
        }
    }
}
