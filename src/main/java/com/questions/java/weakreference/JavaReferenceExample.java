package com.questions.java.weakreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by jitendra on 13 Jun, 2018
 * The ideal solution would be if we can make a type of cache which is dynamic in nature, and can grow and
 * shrink as needed. So we need some kind of technique where we can delete those entries sitting in the
 * cache which will not be used for a long time.
 *
 * To achieve it in Java, we provide different types of reference in the java.lang.ref package.
 *
 * Strong Reference:  We use Strong references in Java everywhere: we can create an object and then assign
 * it to a reference. Note that if the object has a strong reference, this object is never be garbage collected.
 *
 * Example:
 *
 * HelloWorld hello = new HelloWorld();
 *
 * Here hello is the strong reference to HelloWorld Object.
 *
 * Soft Reference: If an object has no strong reference but has a soft reference, then the garbage collector
 * reclaims this object’s memory when GC needs to free up some memory. To get Object from a soft reference,
 * one can invoke the get() method. If the object is not GCed, it returns the object, otherwise , it returns null.
 *
 * Weak Reference: If an object has no strong reference but has a weak reference then GC reclaims this object’s
 * memory in next run even though there is enough memory.
 *
 * Phantom Reference: If an object does not have any of the above references then it may have a phantom reference.
 * Phantom references can’t be accessed directly. When using a get() method it will always return null.
 *
 * Phantom Reference can be used in situations, where sometimes using finalize() is not  sensible.This is a special
 * reference which says that the object was already finalized, and the garbage collector is ready to reclaim its
 * memory.
 */
public class JavaReferenceExample {
    private String status ="Hi I am active";
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "ReferenceExample [status=" + status + "]";
    }
    public void strongReference()
    {
        JavaReferenceExample ex = new JavaReferenceExample();
        System.out.println(ex);
    }
    public void softReference()
    {
        SoftReference<JavaReferenceExample> ex = new SoftReference<>(getRefrence());
        System.out.println("Soft refrence :: " + ex.get());
    }
    public void weakReference()
    {
        int counter=0;
        WeakReference<JavaReferenceExample> ex = new WeakReference<>(getRefrence());
        while(ex.get()!=null)
        {
            counter++;
            System.gc();
            System.out.println("Weak reference deleted  after:: " + counter + "=" + ex.get());
        }
    }
    public void phantomReference() throws InterruptedException
    {
        final ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<JavaReferenceExample> ex = new PhantomReference<JavaReferenceExample>(getRefrence(),queue);
        System.gc();
        queue.remove();
        System.out.println("Phantom reference deleted  after");
    }
    private JavaReferenceExample getRefrence()
    {
        return new JavaReferenceExample();
    }
    public static void main(String[] args) {
        /**
         * Look at the softReference() method. Here we create a soft reference, as memory is
         * available so a reference is not GCed.
         *
         * For weakRefrence(), reference is GCed immediately as there is no strong reference.
         * Same for the Phantom reference.
         */
        JavaReferenceExample ex = new JavaReferenceExample();
        ex.strongReference();
        ex.softReference();
        ex.weakReference();
        try {
            ex.phantomReference();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
