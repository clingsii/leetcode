package com.lc.leetcode;

/**
 * Created by caoling on 16/6/6.
 */
public class T226 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = null;
            if (root.left != null) {
                left = invertTree(root.left);
            }
            TreeNode right = null;
            if (root.right != null) {
                right = invertTree(root.right);
            }
            TreeNode temp = left;
            root.left = right;
            root.right = temp;

        }
        return root;
    }
}
