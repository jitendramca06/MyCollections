package com.questions.java.designpattern.sample.vendingmachine;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public class VendingMachineFactory {
    public static VendingMachine createVendingMachine() {
        return new VendingMachineImpl();
    }
}
