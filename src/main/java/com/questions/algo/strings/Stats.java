package com.questions.algo.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 26/1/19
 */
public class Stats {
    public static class StatisticsAggregatorImpl implements StatisticsAggregator {
        ConcurrentHashMap<String, Double> symbolAvgPrice = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Integer> symbolTicketCountPrice = new ConcurrentHashMap<>();
        @Override
        public void putNewPrice(String symbol, double price) {
            if (!symbolAvgPrice.containsKey(symbol)) {
                symbolAvgPrice.put(symbol, price);
                symbolTicketCountPrice.put(symbol, 1);
            } else {
                //previous total price
                double totalPrice = symbolAvgPrice.get(symbol) * symbolTicketCountPrice.get(symbol);
                //new total price
                totalPrice = totalPrice + price;
                symbolTicketCountPrice.put(symbol, symbolTicketCountPrice.get(symbol) + 1);
                double avgPrice = totalPrice/symbolTicketCountPrice.get(symbol);
                symbolAvgPrice.put(symbol, avgPrice);
            }
        }

        @Override
        public double getAveragePrice(String symbol) {
            if (symbolAvgPrice.get(symbol) == null) return 0;
            return symbolAvgPrice.get(symbol);
        }

        @Override
        public int getTickCount(String symbol) {
            if (symbolTicketCountPrice.get(symbol) == null) return 0;
            return symbolTicketCountPrice.get(symbol);
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }

}
