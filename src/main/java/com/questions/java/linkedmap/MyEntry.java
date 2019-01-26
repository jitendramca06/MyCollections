package com.questions.java.linkedmap;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyEntry<K, V> {
    final K key;
    V value;
    MyEntry<K,V> next;
    MyEntry<K,V> before, after ;

    public MyEntry(K key, V value, MyEntry<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
