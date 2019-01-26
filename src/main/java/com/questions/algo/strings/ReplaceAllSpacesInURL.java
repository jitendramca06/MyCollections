package com.questions.algo.strings;

public class ReplaceAllSpacesInURL {
    public void replace(String s1, int length) {
        char[] chars = s1.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        int newLength = length + 2 * spaceCount;
        char [] charsNew = new char [newLength];

        int index = 0;
        for (int i = 0 ; i < s1.length() ; i++){
            if (chars[i] == ' ') {
                charsNew[index++] = '%';
                charsNew[index++] = '2';
                charsNew[index++] = '0';
            } else charsNew[index++] = chars[i];
        }
        System.out.println("Output String : " + String.valueOf(charsNew));
    }

    public static void main(String args[]) {
        String s1 = "I am jitendra kumar";
        int trueLength = s1.length();
        System.out.println("Input String : " + s1);
        ReplaceAllSpacesInURL r = new ReplaceAllSpacesInURL();
        r.replace(s1, trueLength);
    }
}
