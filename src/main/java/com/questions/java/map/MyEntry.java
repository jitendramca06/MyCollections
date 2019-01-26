package com.questions.java.map;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyEntry<K, V> {
    final K key;
    V value;
    MyEntry<K,V> next;

    public MyEntry(K key, V value, MyEntry<K,V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyEntry<K, V> getNext() {
        return next;
    }
}
