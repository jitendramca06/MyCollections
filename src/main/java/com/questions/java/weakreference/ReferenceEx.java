package com.questions.java.weakreference;

/**
 * Created by jitendra on 14 Mar, 2018
 */
public class ReferenceEx {
    /*
    Four kind of reference in Java :
Strong reference
Soft Reference
Weak Reference
Phantom Reference
Strong Reference is most simple as we use it in our day to day programming
 life e.g. in the code, String s = "abc" , reference variable s has strong
 reference to String object "abc". Any object which has Strong reference attached
 to it is not eligible for garbage collection. Obviously these are objects which is needed
 by Java program. Weak Reference are represented using java.lang.ref.WeakReference class
 and you can create Weak Reference by using following code :

    Counter counter = new Counter(); // strong reference - line 1
    WeakReference<Counter> weakCounter = new WeakReference<Counter>(counter); //weak reference
    counter = null; // now Counter object is eligible for garbage collection

    Now as soon as you make strong reference counter = null, counter object created on line 1
    becomes eligible for garbage collection; because it doesn't have any more Strong reference and
    Weak reference by reference variable weakCounter can not prevent Counter object from being garbage
    collected.  On the other hand, had this been Soft Reference, Counter object is not garbage collected
    until JVM absolutely needs memory. Soft reference in Java is represented using java.lang.ref.SoftReference
    class. You can use following code to create a SoftReference in Java

    Counter prime = new Counter(); // prime holds a strong reference - line 2
    SoftReference<Counter> soft = new SoftReference<Counter>(prime) ; //soft reference variable has SoftReference
    to Counter Object created at line 2
    prime = null; // now Counter object is eligible for garbage collection but only be collected when
    JVM absolutely needs memory

    After making strong reference null, Counter object created on line 2 only has one soft reference
    which can not prevent it from being garbage collected but it can delay collection, which is eager
    in case of WeakReference. Due to this major difference between SoftReference and WeakReference,
    SoftReference are more suitable for caches and WeakReference are more suitable for storing meta data.
    One convenient example of WeakReference is WeakHashMap, which is another implementation of Map
    interface like HashMap or TreeMap but with one unique feature. WeakHashMap wraps keys as WeakReference
    which means once strong reference to actual object removed, WeakReference present internally on
    WeakHashMap doesn't prevent them from being Garbage collected.

Phantom reference is third kind of reference type available in java.lang.ref package. Phantom reference
is represented by java.lang.ref.PhantomReference class. Object which only has Phantom reference pointing
them can be collected whenever Garbage Collector likes it. Similar to WeakReference and SoftReference
you can create PhantomReference by using following code :

DigitalCounter digit = new DigitalCounter(); // digit reference variable has strong reference - line 3
PhantomReference<DigitalCounter> phantom = new PhantomReference<DigitalCounter>(digit); // phantom reference to object created at line 3
digit = null;


     */


}
