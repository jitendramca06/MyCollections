package com.questions.algo.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Jitendra Kumar : 29/8/18
 */
public class BSTTopView {
    /**
     *
     * TODO: This method will not work for all cases
     *                       1
     *                     /    \
     *                   2        3
     *                  /  \     /  \
     *                 4    5    6    \
     *                     / \   /     7
     *                    8   9  13   /
     *                         \      14
     *                         10     /
     *                          \     16
     *                          11
     *                           \
     *                           12
     *
     *                           Output-4 2 1 12 7 (which is wrong)
     *
     */
    private static void topViewOfTreeRec(TreeMap<Integer, String> treeMap, TreeNodeWithLevel root, int level) {
        if (root == null) return;
        if (!treeMap.containsKey(level)) treeMap.put(level, root.data + "");
        topViewOfTreeRec(treeMap, root.left, level - 1);
        topViewOfTreeRec(treeMap, root.right, level + 1);

    }

    private static void topViewOfTreeIte(TreeMap<Integer, String> treeMap, TreeNodeWithLevel root) {
        if (root == null) return;
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNodeWithLevel node = queue.poll();
            if (!treeMap.containsKey(node.level)) treeMap.put(node.level, node.data + "");

            if (node.left != null) {
                node.left.level = node.level -1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.level = node.level + 1;
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        TreeNodeWithLevel root = new TreeNodeWithLevel(50);
        root.left = new TreeNodeWithLevel(30);
        root.right = new TreeNodeWithLevel(70);
        root.left.left = new TreeNodeWithLevel(20);
        root.left.right = new TreeNodeWithLevel(40);
        root.right.left = new TreeNodeWithLevel(60);
        root.right.right = new TreeNodeWithLevel(80);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        topViewOfTreeIte(treeMap, root);
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }

        System.out.println();
        treeMap = new TreeMap<>();
        topViewOfTreeRec(treeMap, root, 0);
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }

        TreeNodeWithLevel root1 = new TreeNodeWithLevel(1);
        root1.left = new TreeNodeWithLevel(2);
        root1.right = new TreeNodeWithLevel(3);
        root1.left.left = new TreeNodeWithLevel(4);
        root1.left.right = new TreeNodeWithLevel(5);
        root1.right.left = new TreeNodeWithLevel(6);
        root1.right.right = new TreeNodeWithLevel(7);
        root1.left.right.left = new TreeNodeWithLevel(8);
        root1.left.right.right = new TreeNodeWithLevel(9);
        root1.left.right.right = new TreeNodeWithLevel(10);
        root1.left.right.right = new TreeNodeWithLevel(11);
        root1.left.right.right = new TreeNodeWithLevel(12);
        root1.right.left.left = new TreeNodeWithLevel(13);
        root1.right.right.left = new TreeNodeWithLevel(14);
        root1.right.right.left.left = new TreeNodeWithLevel(15);
        root1.right.right.left.left.left = new TreeNodeWithLevel(16);

        System.out.println("============Wrong output using recursion===========");
        treeMap = new TreeMap<>();
        topViewOfTreeRec(treeMap, root1, 0);
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }

        System.out.println("============Correct output using iterative===========");
        treeMap = new TreeMap<>();
        topViewOfTreeIte(treeMap, root1);
        for (Map.Entry<Integer, String> map : treeMap.entrySet()) {
            System.out.println(map.getValue());
        }
    }
}
