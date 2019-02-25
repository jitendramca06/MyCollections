package com.questions.algo.arrays;

/**
 * @author Jitendra Kumar : 25/1/19
 */
public class CountTotalZerosAndOnes {
    private static void count(int[] numbers) {
        int start = 0;
        int end = numbers.length;
        countOneAndZero(start, end, numbers);
    }

    private static void countOneAndZero(int start, int end, int [] numbers) {
        if (numbers[start] == numbers[end-1]) {
            if (numbers[start] == 0) {
                System.out.println("1-" + 0);
                System.out.println("0-" + end);
            } else {
                System.out.println("0-" + 0);
                System.out.println("1-" + end);
            }
            return;
        }
        int high = end;
        while (start<end) {
            int mid = start + (end - start)/2;
           if (numbers[mid] == 0 && numbers[mid + 1] == 1) {
               System.out.println("1-" + (high-mid -1));
               System.out.println("0-" + (mid + 1));
               break;
           }else if (numbers[mid] == 1 && numbers[mid - 1] == 0) {
               System.out.println("1-" + (high-mid));
               System.out.println("0-" + (mid));
               break;
           } else if (numbers[mid] == 0 && numbers[mid + 1] == 0){
               start = mid + 1;
           } else if (numbers[mid] == 1 && numbers[mid - 1] == 1) {
               end  = mid - 1;
           }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
        count(numbers);
    }
}
