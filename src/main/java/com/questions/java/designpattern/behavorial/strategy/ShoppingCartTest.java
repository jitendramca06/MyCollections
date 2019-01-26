package com.questions.java.designpattern.behavorial.strategy;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy("myemail@stack.com", "mypwd"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Jitendra Kumar", "1234567890123456", "786", "12/15"));
    }
}
