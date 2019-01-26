package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 19/1/19
 */
public class LowestCommonAncestor {
    private static TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null)
            return root;
        if (root == node1 || root == node2)
            return root;
        TreeNode left = LCA(root.left, node1, node2);
        TreeNode right = LCA(root.right, node1, node2);
        if (left != null && right != null) return root;
        if (left == null) return right;
        else return left;
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /    \
          30     17
         /  \   /  \
       20   40 18   19
       /     \        \
      12      13       20
               \
                14
                 \
                  15
                   \
                    16*/
        TreeNode root1 = new TreeNode(50);
        root1.left = new TreeNode(30);
        root1.left.left = new TreeNode(20);
        TreeNode node1 = root1.left.left.left = new TreeNode(12);
        root1.left.right = new TreeNode(40);
        root1.left.right.right = new TreeNode(13);
        root1.left.right.right.right = new TreeNode(14);
        root1.left.right.right.right.right = new TreeNode(15);
        TreeNode node2 = root1.left.right.right.right.right.right = new TreeNode(16);
        root1.right = new TreeNode(17);
        root1.right.left = new TreeNode(18);
        root1.right.right = new TreeNode(19);
        root1.right.right.right = new TreeNode(20);
        System.out.println(LCA(root1, node1, node2).data);
    }
}
