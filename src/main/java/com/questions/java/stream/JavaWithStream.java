package com.questions.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jitendra on 14 Mar, 2018
 */

/*
Java provides a new additional package in Java 8 called java.util.stream. This package consists of
classes, interfaces and enum to allows functional-style operations on the elements. You can use
stream by importing java.util.stream package.

Stream provides following features:

Stream does not store elements. It simply conveys elements from a source such as a data structure,
an array, or an I/O channel, through a pipeline of computational operations.
Stream is functional in nature. Operations performed on a stream does not modify it's source. For
example, filtering a Stream obtained from a collection produces a new Stream without the filtered
elements, rather than removing elements from the source collection.
Stream is lazy and evaluates code only when required.
The elements of a stream are only visited once during the life of a stream. Like an Iterator, a new
stream must be generated to revisit the same elements of the source.
You can use stream to filter, collect, print, and convert from one data structure to other etc.
In the following examples, we have apply various operations with the help of stream.

Collections vs Streams
Collections are in-memory data structures which hold elements within it. Each element in the collection
is computed before it actually becomes a part of that collection. On the other hand Streams are fixed
data structures which computes the elements on-demand basis.

 The Java 8 Streams can be seen as lazily constructed Collections, where the values are computed when
 user demands for it. Actual Collections behave absolutely opposite to it and they are set of eagerly
 computed values (no matter if the user demands for a particular value or not).
 */
public class JavaWithStream {
    static List<Product> productsList = new ArrayList<Product>();

    static {
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
    }
    public static void streamIterating() {
        Stream.iterate(1, element->element+1)
                .filter(element->element<10)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void filteringIteratingCollection() {
        // This is more compact approach for filtering data
        productsList.stream()
                .filter(product -> product.price == 30000)
                .forEach(product -> System.out.println(product.name));
    }

    public static void sumByUsingCollectorsMethods() {
        // Using Collectors's method to sum the prices.
        double totalPrice3 = productsList.stream()
                .collect(Collectors.summingDouble(product->product.price));
        System.out.println(totalPrice3);
    }

    public static void findMaxMinProductPrice() {
        // max() method to get max Product price
        Product productA = productsList.stream()
                .max((product1, product2)->
                        product1.price > product2.price ? 1: -1).get();

        System.out.println(productA.price);
        // min() method to get min Product price
        Product productB = productsList.stream()
                .min((product1, product2)->
                        product1.price < product2.price ? 1: -1).get();
        System.out.println(productB.price);
    }

    public static void countMethodInCollection() {
        // count number of products based on the filter
        long count = productsList.stream()
                .filter(product->product.price<30000)
                .count();
        System.out.println(count);
    }

    public static void reduceMethod() {
        /*
        This method takes a sequence of input elements and combines them into a single summary
        result by repeated operation. For example, finding the sum of numbers, or accumulating
        elements into a list.
         */
        // This is more compact approach for filtering data
        Float totalPrice = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,(sum, price)->sum+price);   // accumulating price
        System.out.println(totalPrice);
        // More precise code
        float totalPrice2 = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class
        System.out.println(totalPrice2);
    }

    public static void convertListIntoSet() {
        // Converting product List into Set
        Set<Float> productPriceList =
                productsList.stream()
                        .filter(product->product.price < 30000)   // filter product on the base of price
                        .map(product->product.price)
                        .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)
        System.out.println(productPriceList);
    }

    public static void convertListIntoMap() {
        // Converting Product List into a Map
        Map<Integer,String> productPriceMap =
                productsList.stream()
                        .collect(Collectors.toMap(p->p.id, p->p.name));

        System.out.println(productPriceMap);
    }

    public static void methodReferenceInStream() {
        List<Float> productPriceList =
                productsList.stream()
                        .filter(p -> p.price > 30000) // filtering data
                        .map(Product::getPrice)         // fetching price by referring getPrice method
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPriceList);
    }

    public static void streamFilter() {
        productsList.stream()
                .filter(p ->p.price> 30000)   // filtering price
                .map(pm ->pm.price)          // fetching price
                .forEach(System.out::println);  // iterating price
    }

    public static void streamFilterDataAsList() {
        List<Float> pricesList =  productsList.stream()
                .filter(p ->p.price> 30000)   // filtering price
                .map(pm ->pm.price)          // fetching price
                .collect(Collectors.toList());
        System.out.println(pricesList);
    }

    public static void main(String[] args) {
        List<Float> productPriceList2 =productsList.stream()
                .filter(p -> p.price > 30000)// filtering data
                .map(p->p.price)        // fetching price
                .collect(Collectors.toList()); // collecting as list
        System.out.println(productPriceList2);

        streamIterating();
        filteringIteratingCollection();
        reduceMethod();
        sumByUsingCollectorsMethods();
        findMaxMinProductPrice();
        countMethodInCollection();
        convertListIntoSet();
        convertListIntoMap();
        methodReferenceInStream();
    }
}
