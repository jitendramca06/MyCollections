package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 15/12/18
 * Time Complexity: O(m x n)
 * Auxiliary Space: O(m x n)
 *
 * Last three and first characters are same.  We basically
 * need to convert "un" to "atur".  This can be done using
 * below three operations.
 * Replace 'n' with 'r', insert t, insert a
 */
public class EditDistance {

    private static void editDistance(String s1, String s2, int l1, int l2) {
        int[][] dp = new int[l1 +1][l2 +1];

        for (int i = 0 ; i <= l1; i++) {
            for (int j = 0 ; j <= l2 ; j++) {
                if (i  == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (s1.charAt(i-1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        System.out.println(dp[l1][l2]);
    }

    public static void main(String[] args) {
        String string = "sunday";
        String string1 = "saturday";
        editDistance(string, string1, string.length(), string1.length());
    }
}

/**
 * // If first string is empty, the only option is to
 *     // insert all characters of second string into first
 *     if (m == 0) return n;
 *
 *     // If second string is empty, the only option is to
 *     // remove all characters of first string
 *     if (n == 0) return m;
 *
 *     // If last characters of two strings are same, nothing
 *     // much to do. Ignore last characters and get count for
 *     // remaining strings.
 *     if (str1.charAt(m-1) == str2.charAt(n-1))
 *         return editDist(str1, str2, m-1, n-1);
 *
 *     // If last characters are not same, consider all three
 *     // operations on last character of first string, recursively
 *     // compute minimum cost for all three operations and take
 *     // minimum of three values.
 */
