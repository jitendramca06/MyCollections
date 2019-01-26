package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 24/12/18
 */
public class WordBreak {
    private static String[] words = {"mobile", "samsung", "sam", "sung", "man", "mango",
            "icecream", "and", "go", "i", "like", "ice", "cream"};

    private static boolean contains(String word) {
        for (String s : words) {
            if (s.equals(word)) return true;
        }
        return false;
    }

    private static boolean wordBreak(String word) {
        if (word.length() == 0) return true;
        boolean[] dp = new boolean[word.length() + 1];

        for (int i = 1 ;  i <= word.length() ; i++) {
            if (!dp[i] && contains(word.substring(0, i)))
                dp[i] = true;
            if (dp[i]) {
                if (i == word.length()) return true;
                for (int j = i + 1 ; j <= word.length() ; j++) {
                    if (!dp[j] && contains(word.substring(i, j)))
                        dp[j] = true;
                    if (dp[j] && j == word.length()) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmangok"));
    }
}
