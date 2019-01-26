package com.questions.java.designpattern.sample.singleton;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public class WithoutClone implements Cloneable{
    private static WithoutClone withoutClone = null;

    private WithoutClone(){

    }

    public static WithoutClone getInstance() {
        if (withoutClone == null) {
            synchronized (WithoutClone.class) {
                if (withoutClone == null) {
                    withoutClone = new WithoutClone();
                }
            }
        }
        return withoutClone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone is not allowed.");
    }
}
