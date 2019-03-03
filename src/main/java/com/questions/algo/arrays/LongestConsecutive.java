package com.questions.algo.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : num)
            set.add(e);

        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }

    private static void longestIS(int[] numbers) {
        if (numbers == null || numbers.length == 0) System.out.println(0);

        List<Integer> list = new ArrayList<>();
        for (int n : numbers) {
            if (list.size() == 0 || n >= list.get(list.size() - 1)) {
                list.add(n);
            } else {
                int low = 0;
                int high = list.size() - 1;
                while (low < high) {
                    int mid = low + (high-low)/2;
                    if (list.get(mid) < n) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                list.set(high, n);
            }
        }
        System.out.println(list.size());
        System.out.println(list);
    }

    public static void main(String[] args) {
        /**
         * Your algorithm should run in O(n) complexity.
         */
        //int[] a = {100, 4, 200, 1, 3, 2, 2};

        int[] a = {1,2,2, 200,3,4,5,100,102,6};
        System.out.println(longestConsecutive(a));
        longestIS(a);
    }
}
