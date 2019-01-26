package com.questions.algo.dp.others;

/**
 * @author Jitendra Kumar : 17/1/19
 *
 * Time Complexity is O(n^2)
 * Space Complexity is O(n)
 */
public class NumberOfUniqueBSTs {
    /*
     * Total number of BSTs for 'n' distinct keys = total number of BSTs with '1' as root + total number of BSTs with '2' as root
     *                                              + ... + total number of BSTs with 'n' as root
     *
     * Total number of BSTs with 'i' as the root = (Total number of BSTs with 'i-1' distinct keys)*(Total number of BSTs with 'n-i' distinct keys)
     */

    public static void main(String[] args) {
        NumberOfUniqueBSTs solution = new NumberOfUniqueBSTs();

        System.out.print("Total number of BSTs possible for 3 distinct keys: " + solution.numTrees(3));

        System.out.print("\n\nTotal number of BSTs possible for 5 distinct keys: " + solution.numTrees(5));
    }

    // n is input and 'solutions' array stores the intermediate results. All values are initialized to -1
    public int computePossibilities(int n, int[] solutions) {
        // base case
        if ((n == 1) || (n == 0)) return 1;

        int numAllPossibleBSTs = 0;

        // summation of total number of BSTs possible with each value of 'i' as the root
        for (int i = 1; i <= n; i++) {
            if (solutions[i - 1] == -1)
                solutions[i - 1] = computePossibilities(i - 1, solutions); // compute all possible BSTs in its left-subtree

            if (solutions[n - i] == -1)
                solutions[n - i] = computePossibilities(n - i, solutions); // compute all possible BSTs in its right-subtree

            numAllPossibleBSTs += solutions[i - 1] * solutions[n - i]; // multiply these two values and add to total
        }
        return numAllPossibleBSTs;
    }

    public int numTrees(int n) {
        int[] solutions = new int[n + 1];

        for (int i = 0; i <= n; i++)
            solutions[i] = -1;

        return computePossibilities(n, solutions);
    }
}
