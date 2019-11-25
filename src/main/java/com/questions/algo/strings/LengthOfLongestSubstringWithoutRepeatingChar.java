package com.questions.algo.strings;

import java.util.HashSet;

/**
 * @author Jitendra Kumar : 12/5/19
 */
public class LengthOfLongestSubstringWithoutRepeatingChar {

    private static int longestSubString1(String str) {
        String output = "";
        int result = Integer.MIN_VALUE;
        for (Character c : str.toCharArray()) {
            int index = output.indexOf(c);
            if (index < 0) {
                output = output + c;
                if (result < output.length()) {
                    result = output.length();
                }
            }
            else {
                output = output.substring(index +1);
            }
        }
        return result;
    }

    private static int longestSubString(String str) {
        HashSet<String> hashSet = new HashSet<>();
        int result = Integer.MIN_VALUE;
        for (Character c : str.toCharArray()) {
            if(!hashSet.contains(c)) {
                hashSet.add(String.valueOf(c));
                result = Math.max(result, hashSet.size());
            } else {
                for (int i = 0 ; i < hashSet.size() ; i++) {
                    if (hashSet.contains(c)) {
                        hashSet.remove(i);
                        break;
                    }
                    hashSet.remove(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaaaaaabbbbbca";
        System.out.println(longestSubString(s));
        System.out.println(longestSubString1(s));
    }
}
