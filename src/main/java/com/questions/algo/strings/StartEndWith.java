package com.questions.algo.strings;

import java.util.stream.Stream;

/**
 * @author Jitendra Kumar : 11/10/18
 */
public class StartEndWith {

    private static boolean startWith(String original, String prefix) {
        Stream<String> names = Stream.of("Jai","Hemant");
        if (prefix == null || original == null) return false;
        if (prefix.length() > original.length()) return false;
        return startWith(original, prefix, 0);
    }

    private static boolean endWith(String original, String suffix){
        if (suffix == null || original == null) return false;
        if (suffix.length() > original.length()) return false;
        return startWith(original, suffix, original.length() - suffix.length());
    }

    private static boolean startWith(String original, String prefix, int offset) {
        int i = offset;
        int j = 0;
        int prefixSize = prefix.length();
        char[] prefixes = prefix.toCharArray();
        char[] chars = original.toCharArray();
        while (--prefixSize >= 0) {
            if (prefixes[j++] != chars[i++]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(startWith("Jitendra", "Ji"));
        System.out.println(endWith("Jitendra", "tendra"));
        System.out.println(endWith("Jitendra", null));
        System.out.println(endWith("Jitendra", "Kumar"));
    }
}
