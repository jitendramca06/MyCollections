package com.questions.algo.trie;

import java.util.List;

/**
 * @author Jitendra Kumar : 21/3/19
 */
public class SearchPattern {
    private static Container root = new Container();

    private static void insert(Container current, String sentence, int index) {
        current.index.add(index);
        if (sentence.length() > 0) {
            Character character = sentence.charAt(0);
            Container container = current.child.get(character);
            if (container == null) container = new Container();
            current.child.put(character, container);
            insert(container, sentence.substring(1), index+1);
        }
    }

    private static List<Integer> searchPattern(Container current, String pattern) {
        if (current != null && pattern.length() == 0) return current.index;
        Container container = current.child.get(pattern.charAt(0));
        if (container == null) return null;
        return searchPattern(container, pattern.substring(1));
    }

    public static void main(String[] args) {
        Container current = root;
        String sentence = "Trie is an efficient information reTrieval data structure. Using Trie, search complexities can be brought to optimal limit (key length)";
        for (int i = 0 ; i < sentence.length() ; i++) {
            insert(current,sentence.substring(i), i);
        }

        String pattern = "reTrieval";
        List<Integer> index = searchPattern(current, pattern);
        for (int i = 0 ; i < index.size() ; i++) {
            System.out.println((i+1) + " Pattern is found at-" + (index.get(i) - pattern.length()));
        }
        System.out.println();
    }
}
