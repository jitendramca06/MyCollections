package com.questions.java.designpattern.sample.vendingmachine;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public enum Coin {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
    private int denomination;

    private Coin(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
}
