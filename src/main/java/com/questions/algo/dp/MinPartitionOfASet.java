package com.questions.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra Kumar : 15/12/18
 *
 * Partition a set into two subsets such that the difference of subset sums is minimum
 * Time Complexity - O(n*sum)
 */
public class MinPartitionOfASet {

    private static int minPartition(int[] number, int length, int s1, int s2, Map<String, Integer> map) {
        if (length < 0) {
            return Math.abs(s1 - s2);
        }

        // construct a unique map key from dynamic elements of the input
  		// Note that can uniquely identify the subproblem with n & S1 only,
  		// as S2 is nothing but S - S1 where S is sum of all elements
        String key = length + "|" + s1;
        if (!map.containsKey(key)) {
            // Case 1. include current item in the subset S1 and recurse
            // for remaining items (n - 1)
            int inc = minPartition(number, length - 1, s1 + number[length], s2, map);
            // Case 2. exclude current item from subset S1 and recurse for
   			// remaining items (n - 1)
            int exc = minPartition(number, length - 1, s1, s2 + number[length], map);
            map.put(key, Integer.min(inc, exc));
        }
        return map.get(key);
    }

    public static void main(String[] args) {
        int[] numbers = {10,20,15,5,25};
        Map<String, Integer> map = new HashMap<>();
        System.out.println(minPartition(numbers, numbers.length - 1, 0 , 0, map));
    }
}
