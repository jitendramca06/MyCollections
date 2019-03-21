package com.questions.algo.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jitendra Kumar : 20/3/19
 */
public class Container {
    public Map<Character, Container> child;
    public boolean isEnd = false;
    public List<Integer> index = new ArrayList<>();

    public Container() {
        this.child = new HashMap<>();
    }

}
