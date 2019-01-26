package com.questions.java.set;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class CustomHashSet<E> {
    private HashMapCustom<E, Object> hashMapCustom;

    public CustomHashSet(){
        hashMapCustom=new HashMapCustom<>();
    }

    /**
     * add objects in SetCustom.
     */
    public void add(E value){
        hashMapCustom.put(value, null);
    }

    /**
     * Method returns true if set contains the object.
     */
    public boolean contains(E obj){
        return hashMapCustom.contains(obj) !=null ? true :false;
    }

    /**
     * Method displays all objects in setCustom.
     * insertion order is not guaranteed, for maintaining insertion order refer LinkedHashSet.
     */
    public void display(){
        hashMapCustom.displaySet();
    }

    /**
     * Method removes object from setCustom.
     * @param obj
     */
    public boolean remove(E obj){
        return hashMapCustom.remove(obj);
    }

    public static void main(String[] args) {
        CustomHashSet<Integer> hashSetCustom = new CustomHashSet<Integer>();
        hashSetCustom.add(21);
        hashSetCustom.add(25);
        hashSetCustom.add(30);
        hashSetCustom.add(33);
        hashSetCustom.add(35);

        System.out.println("HashSetCustom contains 21 ="+hashSetCustom.contains(21));
        System.out.println("HashSetCustom contains 51 ="+hashSetCustom.contains(51));

        System.out.print("Displaying HashSetCustom: ");
        hashSetCustom.display();

        System.out.println("\n\n21 removed: "+hashSetCustom.remove(21));
        System.out.println("22 removed: "+hashSetCustom.remove(22));

        System.out.print("Displaying HashSetCustom: ");
        hashSetCustom.display();

    }
}
