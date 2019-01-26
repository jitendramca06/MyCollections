package com.questions.algo.strings;

public class RemoveDuplicate {
    private static void removeDupl1(String string) {
        if (string == null)
            System.out.println("Invalid String");
        if (string.length() == 1)
            System.out.println("Not duplicate is found");
        String result = "";
        char[] chars = string.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (result.indexOf(chars[i]) == -1)
                result = result+ chars[i];
        }
        System.out.println(result);
    }

    private static void removeDupl(String string) {
        if (string == null)
            System.out.println("Invalid String");
        if (string.length() == 1)
            System.out.println("Not duplicate is found");

        StringBuilder stringBuilder = new StringBuilder();
        int[] indexes = new int[256];
        for (int i = 0 ; i < 256 ; i++)
            indexes[i] = -1;
        for (int i = 0 ; i < string.length() ; i++) {
            if (indexes[string.charAt(i)] == -1) {
                indexes[string.charAt(i)] = i;
                stringBuilder.append(string.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());

    }

    private static void remove(String string) {
        if (string == null) System.out.println("Invalid String");
        if (string.length() == 1) System.out.println("No any duplicate char");
        char[] chars = string.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            int index = string.indexOf(chars[i]);
            while (index != -1) {
                string = string.substring(0, index) + string.substring(index +1);
                index = string.indexOf(chars[i]);
            }
        }
        System.out.println(string);
    }

    public static void main(String[] args) {
        removeDupl("AABBCCDEF");
        removeDupl1("AABBCCDEFAAAFFF");
        remove("AAB");
    }
}
