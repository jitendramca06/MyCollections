package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 16/12/18
 *
 * Let X[0..m - 1] and Y[0..n - 1] be two strings and m and n be respective
 * lengths.
 *
 *   if (m == 0) return n;
 *   if (n == 0) return m;
 *
 *   // If last characters are same, then add 1 to result and
 *   // recur for X[]
 *   if (X[m - 1] == Y[n - 1])
 *      return 1 + SCS(X, Y, m - 1, n - 1);
 *
 *   // Else find shortest of following two
 *   //  a) Remove last character from X and recur
 *   //  b) Remove last character from Y and recur
 *   else return 1 + min( SCS(X, Y, m - 1, n), SCS(X, Y, m, n - 1) );
 */
public class ShortestCommonSupersequence {
    private static int lcs(String s1, String s2, int l1, int l2) {
        int[][] dp = new int[l1 + 1][l2 + 2];

        for (int i = 0 ; i <= l1 ; i++) {
            for (int j = 0 ; j <= l2 ; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[l1][l2];
    }
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of the shortest supersequence is "
                + lcs(X, Y, X.length(),Y.length()));
    }
}
