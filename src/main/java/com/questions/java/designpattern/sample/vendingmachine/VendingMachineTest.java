package com.questions.java.designpattern.sample.vendingmachine;

import java.util.List;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public class VendingMachineTest {

    private long getTotal(List<Coin> change) {
        long total = 0;
        for (Coin c : change) {
            total = total + c.getDenomination();
        }
        return total;
    }

    private void testBuyItemWithExactPrice(VendingMachine vm) {
        long price = vm.selectItemAndGetPrice(Item.COKE);
        System.out.println("Price of item-" + price);
        vm.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst();
        System.out.println("Got item-" + item.getName());
        List<Coin> change = bucket.getSecond();
        System.out.println("Got change-" + change);
    }

    private void testBuyItemWithMorePrice(VendingMachine vm) {
        long price = vm.selectItemAndGetPrice(Item.SODA);
        System.out.println("Price of item-" + price);

        vm.insertCoin(Coin.QUARTER);
        vm.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst();
        List<Coin> change = bucket.getSecond();
        System.out.println("Got item-" + item.getName());
        System.out.println("Got change-" + getTotal(change));
    }

    private void testRefund(VendingMachine vm) {
        long price = vm.selectItemAndGetPrice(Item.PEPSI);
        System.out.println("Item price - " + price);
        vm.insertCoin(Coin.DIME);
        vm.insertCoin(Coin.NICKLE);
        vm.insertCoin(Coin.PENNY);
        vm.insertCoin(Coin.QUARTER);
        System.out.println("Refund amount-" + vm.refund());

    }

    public void testSoldOut(VendingMachine vm) {
        for (int i = 0; i < 5; i++) {
            vm.selectItemAndGetPrice(Item.COKE);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange();
        }
    }

    public void testNotSufficientChangeException(VendingMachine vm) {
        for (int i = 0; i < 5; i++) {
            vm.selectItemAndGetPrice(Item.SODA);
            vm.insertCoin(Coin.QUARTER);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange();
            vm.selectItemAndGetPrice(Item.PEPSI);
            vm.insertCoin(Coin.QUARTER);
            vm.insertCoin(Coin.QUARTER);
            vm.collectItemAndChange();
        }
    }

    public void testReset() {
        VendingMachine vmachine = VendingMachineFactory.createVendingMachine();
        vmachine.reset();
        vmachine.selectItemAndGetPrice(Item.COKE);
    }

    public static void main(String[] args) {
        System.out.println("=======================buy with exact price================");
        VendingMachineTest vendingMachineTest = new VendingMachineTest();
        VendingMachine vm = VendingMachineFactory.createVendingMachine();
        vendingMachineTest.testBuyItemWithExactPrice(vm);
        System.out.println("=======================buy with more price================");
        vendingMachineTest.testBuyItemWithMorePrice(vm);
        System.out.println("=======================Refund================");
        vendingMachineTest.testRefund(vm);
        System.out.println("=======================Not sufficient cahnge================");
        vendingMachineTest.testNotSufficientChangeException(vm);
    }
}
