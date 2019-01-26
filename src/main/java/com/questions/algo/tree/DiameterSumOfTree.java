package com.questions.algo.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra Kumar : 19/1/19
 */
public class DiameterSumOfTree {
    private static void diameterSum(TreeNode root, int diameter, Map<Integer, Integer> map) {
        if (root == null) return;
        diameterSum(root.left, diameter + 1, map);
        int previous = 0;
        if (map.containsKey(diameter)) {
            previous = map.get(diameter);
        }
        map.put(diameter, root.data + previous);
        diameterSum(root.right, diameter, map);
    }
    public static void main(String[] args) {
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        Map<Integer, Integer> map = new HashMap<>();
        diameterSum(root, 1, map);
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + "=" + m.getValue());
        }
    }
}
