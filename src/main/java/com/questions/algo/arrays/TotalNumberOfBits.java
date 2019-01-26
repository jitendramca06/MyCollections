package com.questions.algo.arrays;

/**
 * @author Jitendra Kumar : 5/12/18
 */
public class TotalNumberOfBits {
    /**
     * O(n log n)
     *
     */
    private static int setBits(int number) {
        if (number == 0) return 0;
        int count = 0;
        for (int i = 1 ; i <= number ;i++) {
            count += totalSetBits(i);
        }
        return count;
    }

    private static  int totalSetBits(int number) {
        if (number <= 0) return 0;
        return (number % 2 == 0 ? 0 : 1) + totalSetBits(number/2);
    }

    public static void main(String[] args) {
        System.out.println(setBits(4));
    }
}
