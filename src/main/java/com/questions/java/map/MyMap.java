package com.questions.java.map;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyMap<K, V> {
    private int size;
    private int DEFAULT_CAPACITY = 16;
    private MyEntry<K, V>[] table = new MyEntry[DEFAULT_CAPACITY];


    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            MyEntry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }

    /**
     * Method allows you put key-value pair in HashMapCustom.
     * If the map already contains a mapping for the key, the old value is replaced.
     * Note: method does not allows you to put null key though it allows null values.
     * Implementation allows you to put custom objects as a key as well.
     * Key Features: implementation provides you with following features:-
     * >provide complete functionality how to override equals method.
     * >provide complete functionality how to override hashCode method.
     **/
    public void put(K key, V value) {
        if (key == null)
            return;    //does not allow to store null.

        //calculate hash of key.
        int hash = hash(key);
        //create new entry.
        MyEntry<K, V> newEntry = new MyEntry<K, V>(key, value, null);

        //if table location does not contain any entry, store entry there.
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            MyEntry<K, V> previous = null;
            MyEntry<K, V> current = table[hash];

            while (current != null) { //we have reached last entry of bucket.
                if (current.key.equals(key)) {
                    if (previous == null) {  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    public int size() {
        return size;
    }

    public boolean remove(K key) {
        int hash = hash(key);

        if (table[hash] == null) {
            return false;
        } else {
            MyEntry<K, V> previous = null;
            MyEntry<K, V> current = table[hash];

            while (current != null) { //we have reached last entry node of bucket.
                if (current.key.equals(key)) {
                    if (previous == null) {  //delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    public void display() {

        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (table[i] != null) {
                MyEntry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }

    }
}
