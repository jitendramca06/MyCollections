package com.questions.algo.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra Kumar : 20/3/19
 */
public class Container {
    public Map<Character, Container> child;
    public boolean isEnd = false;

    public Container() {
        this.child = new HashMap<>();
    }

}
