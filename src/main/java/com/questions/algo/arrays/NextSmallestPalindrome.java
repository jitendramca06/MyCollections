package com.questions.algo.arrays;

/**
 * @author Jitendra Kumar : 12/5/19
 */
public class NextSmallestPalindrome {

    public static void main(String[] args) {
        int[] arr = {3,9,3, 0};
        if (isAllDigitsAre9(arr)) {
            arr = forHighestVal(arr);
            System.out.println(print(arr));
        } else {
            nextSmallestPalindrome(arr);
            System.out.println(print(arr));
        }
    }

    private static void nextSmallestPalindrome(int[] arr) {
        int mid = arr.length / 2;
        int left = mid -1;
        int right = arr.length % 2 == 0 ? mid : mid +1;

        while (left >= 0 && arr[left] == arr[right]) {
            left--;
            right++;
        }

        boolean shouldCopy = false;

        if (left < 0 || arr[left] != arr[right]) {
            shouldCopy = true;
        }

        while (left >= 0) {
            arr[right++] = arr[left--];
        }

        if (shouldCopy) {
            int carry = 1;
            if (arr.length % 2 == 1) {
                arr[mid] = arr[mid] + 1;
                carry = arr[mid] / 10;
                arr[mid] = arr[mid] % 10;
            }

            left = mid - 1;
            right = arr.length %2 == 0 ? mid : mid + 1;

            while (left >= 0) {
                arr[left] = arr[left] + carry;
                carry = arr[left] / 10;
                arr[left] = arr[left] % 10;
                arr[right] = arr[left];
                left--;
                right++;
            }
        }
    }

    private static boolean isAllDigitsAre9(int[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] != 9) return false;
        }
        return true;
    }

    private static int[] forHighestVal(int[] arr) {
        int[] newArr = new int[arr.length + 1];
        newArr[0] = 1;
        newArr[newArr.length-1] = 1;
        for (int i = 1 ; i < arr.length - 1 ; i++) newArr[i] = 0;
        return newArr;
    }

    private static String print(int[] arr) {
        String output = "";
        for(int i = 0 ; i < arr.length ;i++) {
            output = output + arr[i];
        }
        return output;
    }
}
