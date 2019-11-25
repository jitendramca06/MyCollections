package com.questions.java.thread.callable;

import java.util.Random;

/**
 * @author Jitendra Kumar : 24/11/19
 */
public class Data {
    private int a;
    private int b;
    private int c;
    private int d;
    private String all;
    private Random random = new Random();

    public int getA() {
        return a;
    }

    public void setA() {
        this.a = random.nextInt(100) +1;
    }

    public int getB() {
        return b;
    }

    public void setB() {
        this.b = random.nextInt(100) +1;
    }

    public int getC() {
        return c;
    }

    public void setC() {
        this.c = random.nextInt(100) +1;
    }

    public int getD() {
        return d;
    }

    public void setD() {
        this.d = random.nextInt(100) +1;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        if (this.all == null) this.all = "";
        this.all = this.all + "-" + all;
    }

    public Data add(Data data) {
        this.a = this.a + data.getA();
        this.b = this.b + data.getB();
        this.c = this.c + data.getC();
        this.d = this.d + data.getD();
        this.setAll(data.getAll());
        return this;
    }

    @Override
    public String toString() {
        return "Data{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", all='" + all + '\'' +
                '}';
    }
}
