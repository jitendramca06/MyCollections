package com.questions.java.enumexample;

/**
 * Created by jitendra on 20 Mar, 2018
 *
 * It’s not really a matter of ‘power’, it’s actually more restrictive, but that’s a good thing.
 *
 * Let’s look at the classic example
 *
 * public enum Day {
 *     SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
 *     THURSDAY, FRIDAY, SATURDAY
 * }
 * OK, this could just as easily be setup as a number, rather than use an enum, we just use 1 for Monday, 2 for Tuesday and so on…
 *
 * But, what happens when we use these incorrectly?
 *
 * If 1 is Monday, what is 0? What is 56?
 *
 * By using integer constants, we’re introducing a point of potential error, quite a big one.
 *
 * By using enums we’re restricting the values, to the only the correct ones.
 *
 * Enums, in this sense, are not more powerful, they are significantly less powerful, but that’s a really good thing.
 *
 * The ideal programming language stops you from making as many mistakes as it possibly can, and it also makes the code readable. Enums do both of those things.
 */
public enum Planet {
    A(10, 20, 30),
    B(11, 21, 31),
    C(12, 22, 32),
    D(13, 23, 33),
    E(14, 24, 34);
    private final int x;
    private final int y;
    private final int z;

    Planet(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
