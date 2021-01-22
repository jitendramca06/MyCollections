package com.questions.algo.gfg.amazon;

/**
 * @author Jitendra Kumar : 11/12/19
 */
public class ReplaceAllZeroWithANo {

    private static int replace(int number, int replacingNo) {
        if (number == 0) return 0;
        int n = number % 10;
        if (n == 0) n = replacingNo;
        return replace(number/10, replacingNo) * 10 + n;
    }
    public static void main(String[] args) {
        int number = 101200009;
        int replacingNo = 5;
        System.out.println(replace(number, replacingNo));
    }
}
