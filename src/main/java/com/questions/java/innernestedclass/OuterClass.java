package com.questions.java.innernestedclass;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by jitendra on 14 Mar, 2018
 */

/*
Java inner class is defined inside the body of another class. Java inner class can be declared private, public,
protected, or with default access whereas an outer class can have only public or default access.
1. static nested class

If the nested class is static, then it’s called static nested class. Static nested classes can access only
static members of the outer class. Static nested class is same as any other top-level class and is nested
for only packaging convenience.

2. java inner class
Any non-static nested class is known as inner class in java. Java inner class is associated with the object
of the class and they can access all the variables and methods of the outer class.
Since inner classes are associated with instance, we can’t have any static variables in them.
Object of java inner class are part of the outer class object and to create an instance of inner class,
we first need to create instance of outer class.

Benefits of Java Inner Class

If a class is useful to only one class, it makes sense to keep it nested and together. It helps in packaging of
the classes.
Java inner classes implements encapsulation. Note that inner classes can access outer class private members
and at the same time we can hide inner class from outer world.
Keeping the small class within top-level classes places the code closer to where it is used and makes code
more readable and maintainable.
 */
public class OuterClass {
    private static String name = "OuterClass";
    public int l;
    protected int j;
    int k;
    private int i;

    //OuterClass constructor
    public OuterClass(int i, int j, int k, int l) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
    }

    public int getI() {
        return this.i;
    }

    //local inner class
    public void print(String initial) {
        //local inner class inside the method
        class Logger {
            String name;

            public Logger(String name) {
                this.name = name;
            }

            public void log(String str) {
                System.out.println(this.name + ": " + str);
            }
        }

        Logger logger = new Logger(initial);
        logger.log(name);
        logger.log("" + this.i);
        logger.log("" + this.j);
        logger.log("" + this.k);
        logger.log("" + this.l);
    }

    //anonymous inner class
    public String[] getFilesInDir(String dir, final String ext) {
        File file = new File(dir);
        //String[] filesList1 = file.list((dirr,name)-> name.endsWith(ext));
        //anonymous inner class implementing FilenameFilter interface
        String[] filesList = file.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }

        });
        return filesList;
    }

    //static nested class, can access OuterClass static variables/methods
    static class StaticNestedClass {
        public int d;
        protected int b;
        int c;
        private int a;

        public int getA() {
            return this.a;
        }

        public String getName() {
            return name;
        }
    }

    //inner class, non static and can access all the variables/methods of outer class
    //Can not declare static variable because we need object to access inner class variable
    class InnerClass {
        public int z;
        protected int x;
        int y;
        private int w;

        public int getW() {
            return this.w;
        }

        public void setValues() {
            this.w = i;
            this.x = j;
            this.y = k;
            this.z = l;
        }

        @Override
        public String toString() {
            return "w=" + w + ":x=" + x + ":y=" + y + ":z=" + z;
        }

        public String getName() {
            return name;
        }
    }
}
