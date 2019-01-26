package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 24/12/18
 */
public class EggDroppingPrb {
    private static int calculate(int eggs, int floors) {

        int T[][] = new int[eggs + 1][floors + 1];
        int c = 0;
        // We need one trial for one floor and0 trials for 0 floors
        for (int i = 0; i <= floors; i++) {
            T[1][i] = i;
            T[0][i] = 0;
        }

        // Fill rest of the entries in table using optimal substructure
        // property
        for (int e = 2; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                T[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
                    if (c < T[e][f]) {
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[eggs][floors];
    }

    public static void main(String[] args) {
        System.out.println(calculate(2, 36));
    }

    /*

     When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.

  k ==> Number of floors
  n ==> Number of Eggs
  eggDrop(n, k) ==> Minimum number of trials needed to find the critical
                    floor in worst case.
  eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
                 x in {1, 2, ..., k}}
     */
}
