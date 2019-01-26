package com.questions.java.immutable;

import java.util.ArrayList;

/**
 * Created by jitendra on 12 Mar, 2018
 */
public final class ImmutableWithArrayList {
    private final int id;

    private final String name;

    private final ArrayList<Integer> list;

    //Constructor performing Shallow Copy
    /*ImmutableWithArrayList(int id, String name, ArrayList<Integer> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }*/

    //Constructor performing Deep Copy
    ImmutableWithArrayList(int id, String name, ArrayList<Integer> list) {
        this.id = id;
        this.name = name;
        this.list = newList(list);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getList() {
        return newList(list);
    }

    private ArrayList<Integer> newList(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (Integer i : list) newList.add(i);
        return newList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int id = 10;
        String name = "original";

        ImmutableWithArrayList obj = new ImmutableWithArrayList(id, name, list);

        System.out.println("id:" + obj.getId());
        System.out.println("name:" + obj.getName());
        System.out.println("list:" + obj.getList());

        id = 20;
        name = "modified";
        list.add(3);

        System.out.println("id after local variable change:" + obj.getId());
        System.out.println("name after local variable change:" + obj.getName());
        System.out.println("list after local variable change:" + obj.getList());

        ArrayList<Integer> listTest = obj.getList();
        listTest.add(4);

        System.out.println("list after changing variable from accessor methods:" + obj.getList());
    }
}
