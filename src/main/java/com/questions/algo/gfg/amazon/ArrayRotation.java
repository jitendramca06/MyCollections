package com.questions.algo.gfg.amazon;

/**
 * @author Jitendra Kumar : 11/12/19
 */
public class ArrayRotation {
    private static void rotate(int[] array, int d) {
        if (d == 0) return;
        rotate(array, 0, d-1);
        rotate(array, d, array.length-1);
        rotate(array, 0, array.length-1);
    }

    private static void rotate(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        rotate(array, 6);
        for (int a : array) {
            System.out.print(a + "  ");
        }
    }
}
