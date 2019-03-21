package com.questions.algo.trie;

import java.util.Map;

/**
 * @author Jitendra Kumar : 20/3/19
 */
public class InsertAndSearch {
    private static Container root = new Container();

    private static void insert(String word) {
        Container current = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (current.child.get(character) == null) {
                current.child.put(character, new Container());
            }
            current = current.child.get(character);
        }
        current.isEnd = true;
    }

    private static boolean isFound(String word) {
        Container current = root;
        for (int i = 0 ; i < word.length() ; i++) {
            Character character = word.charAt(i);
            current = current.child.get(character);
            if (current == null) return false;
        }
        return current != null && current.isEnd;
    }

    private static void longestPrefixOfaWord(String word) {
        Container current = root;
        String output = "";
        String temp = "";
        for (int i = 0 ; i < word.length() ; i++) {
            Character character = word.charAt(i);
            temp = temp + character;
            current = current.child.get(character);
            if (current == null) {
                break;
            }
            if (current.isEnd) {
                if (temp.length() > output.length()) output = temp;
            }
        }
        System.out.println(output);
    }

    private static void autoSuggestion(String prefix) {
        Container current = root;
        for (int i = 0 ; i < prefix.length() ; i++) {
            Character character = prefix.charAt(i);
            current = current.child.get(character);
            if (current == null) {
                break;
            }

        }
        if (current == null) {
            System.out.println("No any word with prefix-" + prefix);
            return;
        }
        printAllWord(current, prefix);
    }

    private static void printAllWord(Container current, String output) {
        if (current == null || current.child == null || current.isEnd) {
            System.out.println(output);
        }
        for (Map.Entry<Character, Container> m : current.child.entrySet()) {
            Container container = m.getValue();
            output = output + m.getKey();
            printAllWord(container, output);
            output = output.substring(0, output.length() -1);
        }
    }

    public static void main(String[] args) {
        String[] words = {"hello", "hi", "hell","he","jitendra","kumar","jitu","jignesh"};
        for (String s : words) {
            insert(s);
        }
        System.out.println(isFound("jitu"));
        String prefix = "jit";
        System.out.println("================Word Start With '" + prefix + "' =======================");
        autoSuggestion(prefix);
        String word = "jitendrakumar";
        System.out.println("================Longest prefix '" + word + "' =======================");
        longestPrefixOfaWord(word);
    }
}
