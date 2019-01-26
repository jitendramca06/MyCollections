package com.questions.java.innernestedclass;

import java.util.Arrays;

/**
 * Created by jitendra on 14 Mar, 2018
 */
public class InnerClassTest {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass(1,2,3,4);

        //static nested classes example
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        OuterClass.StaticNestedClass staticNestedClass1 = new OuterClass.StaticNestedClass();

        System.out.println(staticNestedClass.getName());
        staticNestedClass.d=10;
        System.out.println(staticNestedClass.d);
        System.out.println(staticNestedClass1.d);

        //inner class example
        OuterClass.InnerClass innerClass = outer.new InnerClass();
        System.out.println(innerClass.getName());
        System.out.println(innerClass);
        innerClass.setValues();
        System.out.println(innerClass);

        //calling method using local inner class
        outer.print("Outer");

        //calling method using anonymous inner class
        System.out.println(Arrays.toString(outer.getFilesInDir("src/com/common/innernestedclass", ".java")));

        System.out.println(Arrays.toString(outer.getFilesInDir("bin/com/common/innernestedclass", ".class")));
    }
}
