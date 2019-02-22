package com.questions.algo.strings;

import java.util.PriorityQueue;

/**
 * @author Jitendra Kumar : 7/2/19
 * O(n log n)
 */
public class NoThreeAdjacentSame {
    private static String arrangeString(String a, String b, int consecutiveCount) {
        String ab = a + b;
        char[] chars = ab.toCharArray();
        PriorityQueue<Key> queue = new PriorityQueue<Key>((o1, o2) -> {
            if (o1.frequency < o2.frequency) return 1;
            else if (o1.frequency > o2.frequency) return -1;
            return 0;
        });

        int[] count = new int[26];

        for (int i = 0 ; i < chars.length ; i++) {
            count[chars[i] - 97]++;
        }

        for (int i = 0 ; i < count.length ; i++) {
            if (count[i] > 0) {
                Key key = new Key(count[i], (char)(i+97));
                queue.add(key);
            }
        }

        Key previous = new Key(-1, ' ');
        String result = "";
        while (!queue.isEmpty()) {
            Key key = queue.peek();
            queue.poll();
            if (previous.frequency > 0) {
                queue.add(previous);
            }
            result = result + key.aChar;
            key.frequency--;
            previous = key;
        }
        if (result.length() != ab.length()) return "Invalid";
        return result;
    }

    static class Key {
        int frequency;
        char aChar;

        Key(int frequency, char aChar) {
            this.frequency = frequency;
            this.aChar = aChar;
        }
    }

    public static void main(String[] args) {
        String a = "bbb";
        String b = "aa";
        System.out.println(arrangeString(a, b, 3));

    }
}
