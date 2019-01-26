package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class CheckTwoNodesAreCousin {
    private static int findLevel(TreeNode root, TreeNode node, int level) {
        if (root == null) {
            return -1;
        }

        if (root.data == node.data) {
            return level;
        }

        int leftL = findLevel(root.left, node, level +1);
        if (leftL != -1) return leftL;
        int rightL = findLevel(root.right, node, level +1);
        if (rightL != -1) return rightL;
        return -1;
    }

    private static boolean checkCousinRec(TreeNode root, TreeNode node1, TreeNode node2) {
        int level1 = findLevel(root, node1, 0);
        int level2 = findLevel(root, node2, 0);
        if (level1 == -1 || level2 == -1) return false;
        if (level1 != level2) return false;
        return isCousinRec(root, node1, node2);
    }

    private static boolean isCousinRec(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return false;
        /*return ((root.left == node1 && root.right == node2) ||
                (root.left == node2 && root.right == node1) ||
                isCousinRec(root.left, node1, node2) ||
                isCousinRec(root.right, node1, node2));*/
        if (root.left != null && root.right != null) {
            if ((root.left.data == node1.data && root.right.data == node2.data)
            || (root.left.data == node2.data && root.right.data == node1.data)) {
                return false; // because these node have same parent
            }
        }

        boolean left = isCousinRec(root.left, node1, node2);
        if (!left) return false;
        boolean right = isCousinRec(root.right, node1, node2);
        if (!right) return false;
        return true;
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
        //System.out.println(checkCousinRec(root, root.left.left, root.left.right));
        System.out.println(checkCousinRec(root, root.left.right, root.right.left));
    }
}
