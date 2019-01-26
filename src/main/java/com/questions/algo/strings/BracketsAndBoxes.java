package com.questions.algo.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Jitendra Kumar : 27/9/18
 */
public class BracketsAndBoxes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ch;
        do {
            System.out.print("Input data : ");
            String input = scanner.next();
            isOK(input);
            System.out.print("Do you want to continue?");
            ch = scanner.next();
        } while (ch.equalsIgnoreCase("yes") || ch.equalsIgnoreCase("y"));
    }

    private static void isOK(String input) {
        String temp = input;
        if (!temp.contains("B") || temp.startsWith("B") || temp.endsWith("B")) {
            System.out.println("Bad");
            System.out.println("Can not be fixed");
            return;
        }
        if (temp.contains("()")) {
            System.out.println("Bad");
            temp = temp.replace("()", "");
            fixed(temp);
            return;
        } else if (temp.contains("{}")) {
            System.out.println("Bad");
            temp = temp.replace("{}", "");
            fixed(temp);
            return;
        } else if (temp.contains("[]")) {
            System.out.println("Bad");
            temp = temp.replace("[]", "");
            fixed(temp);
            return;
        }
        temp = temp.replace("B", "");
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = -1;
            if (chars[i] == '[') {
                index = temp.indexOf(']');
            } else if (chars[i] == '{') {
                index = temp.indexOf('}');
            } else if (chars[i] == '(') {
                index = temp.indexOf(')');
            }
            if (index >= 0) {
                temp = temp.substring(0, index) + temp.substring(index + 1);
                temp = temp.substring(1);
            }
        }
        if (temp.isEmpty()) System.out.println("Okay");
        else {
            System.out.println("Bad");
            fixed(input);
        }
    }

    private static void fixed(String input) {
        Stack<String> stack = new Stack<>();
        Map<String, String> keyVal  = new HashMap<>();
        keyVal.put("(", ")");
        keyVal.put("{", "}");
        keyVal.put("[", "]");
        String result = "";

        char[] chars = input.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            String cChar = chars[i] + "";
            if (keyVal.containsKey(cChar)) {
                stack.push(keyVal.get(cChar));
                result = result + cChar;
            } else if (cChar.equals("B")) {
                result = result + cChar;
            } else if (keyVal.containsValue(cChar)) {
                String closer = "";
                if (!stack.isEmpty()) {
                    closer = stack.pop();
                }
                if (closer.equals(cChar)) {
                    result = result + closer;
                    continue;
                }
                while (!closer.equals(cChar)) {
                    result = result + closer;
                    if (stack.isEmpty()) break;
                    closer = stack.pop();
                    if (closer.equals(cChar)) {
                        result = result + closer;
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        if (result.contains("()")) {
            result = result.replace("()", "");
        } else if (result.contains("{}")) {
            result = result.replace("{}", "");
        } else if (result.contains("[]")) {
            result = result.replace("[]", "");
        } else if (!result.contains("B") ||
                result.startsWith("B") ||
                result.endsWith("B")) {
            System.out.println("Bad");
            System.out.println("Can not be fixed");
            return;
        }
        System.out.println("Fixed Description : " + result);
    }
}
