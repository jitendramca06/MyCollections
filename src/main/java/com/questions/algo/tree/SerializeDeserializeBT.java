package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 3/9/18
 */
public class SerializeDeserializeBT {
    private static StringBuilder serialiseBT(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("null");
            stringBuilder.append(",");
            return stringBuilder;
        }
        stringBuilder.append(root.data);
        stringBuilder.append(",");
        serialiseBT(root.left, stringBuilder);
        serialiseBT(root.right, stringBuilder);
        return stringBuilder;
    }

    private static TreeNode deserialize(String[] strings, int[] index) {
        if (strings.length < index[0] || strings[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strings[index[0]++]));
        node.left = deserialize(strings, index);
        node.right = deserialize(strings, index);
        return node;
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
        StringBuilder result = serialiseBT(root, new StringBuilder());
        System.out.println(result.toString());
        String[] strings = result.toString().split(",");
        TreeNode head = deserialize(strings, new int[]{0});
        System.out.println(serialiseBT(head, new StringBuilder()));
    }
}
