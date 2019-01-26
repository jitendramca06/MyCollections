package com.questions.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class FindLevelOrHeightOfANode {
    private static int findLevelRec(TreeNode root, TreeNode node, int currentLevel) {
        if (root == null) return -1;
        if (root.data == node.data) return currentLevel;
        int leftLevel = findLevelRec(root.left, node, currentLevel + 1);
        if (leftLevel != -1) return leftLevel;
        int rightLevel = findLevelRec(root.right, node, currentLevel +1);
        if (rightLevel != -1) return rightLevel;
        return -1;
    }

    private static int findLevelIte(TreeNode root, TreeNode node) {
        if (root == null) return -1;
        int currentLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                currentLevel++;
                if (queue.peek() != null) {
                    queue.add(null);
                }
            }else {
                if (treeNode.data == node.data) {
                    return currentLevel;
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return currentLevel;
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
        System.out.println(findLevelRec(root, root.left.left, 0));
        System.out.println(findLevelIte(root, root.left.left));
    }
}
