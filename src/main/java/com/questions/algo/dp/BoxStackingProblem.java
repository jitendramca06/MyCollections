package com.questions.algo.dp;

import java.util.Arrays;

/**
 * @author Jitendra Kumar : 24/12/18
 */
public class BoxStackingProblem {
    private static void maxStackHeight(Box[] boxes, int n) {
        Box[] rot = new Box[3 * n];
        for (int i = 0; i < n; i++) {
            Box box = boxes[i];
            rot[3 * i] = new Box(box.height, Math.max(box.length, box.width), Math.min(box.length, box.width));
            rot[3 * i + 1] = new Box(box.width, Math.max(box.length, box.height), Math.min(box.length, box.height));
            rot[3 * i + 2] = new Box(box.length, Math.max(box.width, box.height), Math.min(box.width, box.height));
        }

        for (int i = 0; i < rot.length; i++)
            rot[i].area = rot[i].length * rot[i].width;
        Arrays.sort(rot);

        int[] mCount = new int[rot.length];

        for (int i = 0; i < rot.length; i++) {
            mCount[i] = 0;
            Box box = rot[i];
            int val = 0;

            for (int j = 0; j < i; j++) {
                Box prev = rot[j];
                if (prev.length > box.length && prev.width > box.width) {
                    val = Math.max(val, mCount[j]);
                }
            }
            mCount[i] = box.height + val;
        }

        int max = -1;

        for (int i = 0; i < mCount.length; i++) {
            max = Math.max(max, mCount[i]);
        }

        System.out.println("The maximum possible " +
                "height of stack is " + max);
    }

    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);

        maxStackHeight(arr, 4);
    }

    static class Box implements Comparable<Box> {
        private int height;
        private int length;
        private int width;
        private int area;

        Box(int height, int length, int width) {
            this.height = height;
            this.length = length;
            this.width = width;
        }

        @Override
        public int compareTo(Box o) {
            return o.area - this.area;
        }
    }
}
