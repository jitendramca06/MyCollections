package com.questions.java.designpattern.sample.vendingmachine;

import java.util.List;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public interface VendingMachine {
    public long selectItemAndGetPrice(Item item);

    public void insertCoin(Coin coin);

    public List<Coin> refund();

    public Bucket<Item, List<Coin>> collectItemAndChange();

    public void reset();
}
