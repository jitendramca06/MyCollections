package com.questions.java.constrictorcalling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jitendra Kumar : 21/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        SupperClass supperClass = new Child1();
        System.out.println(supperClass.a);
        System.out.println(supperClass.getA());
        SupperClass c = new Child2();
        c.print();
        System.out.println("==========================");
        Child2 child2 = new Child2();
        child2.print();
        Child2[] child2s = new Child2[100];
        /**
         * Valid initialization
         */
        SupperClass[] SupperClasss = child2s;
        List<Child2> child2List = new ArrayList<>();
        /**
         * Not a valid initialization
         */
        //List<SupperClass> supperClassList = child2List;
    }
}
