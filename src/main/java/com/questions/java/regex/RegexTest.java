package com.questions.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jitendra Kumar : 6/10/18
 */
public class RegexTest {
    public static void main(String[] args) {
        System.out.println("? quantifier ....");
        //true (a or j or n comes one time)
        System.out.println(Pattern.matches("[ajn]?", "a"));
        //false (a comes more than one time)
        System.out.println(Pattern.matches("[ajn]?", "aaa"));
        //false (a j and n comes more than one time)
        System.out.println(Pattern.matches("[ajn]?", "aammmnn"));
        //false (a comes more than one time)
        System.out.println(Pattern.matches("[ajn]?", "aazzta"));
        //false (a or j or n must come one time)
        System.out.println(Pattern.matches("[ajn]?", "ajn"));
        //false (a or j or n must come one time)
        System.out.println(Pattern.matches("[ajn]?", "aj"));
        //true (a or j or n must come one time)
        System.out.println(Pattern.matches("[ajn]?", "n"));

        System.out.println("+ quantifier ....");
        //true (a or j or n once or more times)
        System.out.println(Pattern.matches("[ajn]+", "a"));
        //true (a comes more than one time)
        System.out.println(Pattern.matches("[ajn]+", "aaa"));
        //true (a or j or n comes more than once)
        System.out.println(Pattern.matches("[ajn]+", "aammmnn"));
        //false (z and t are not matching pattern)
        Pattern pattern = Pattern.compile("[ajn]");
        Matcher matcher = pattern.matcher("aazzta");
        System.out.println(matcher.find());
        System.out.println(Pattern.matches("[ajn]+", "aazzta"));

        System.out.println("* quantifier ....");
        //true (a or j or n may come zero or more times)
        System.out.println(Pattern.matches("[ajn]*", "ajjjna"));
    }
}
