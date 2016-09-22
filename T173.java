package com.lc.leetcode;

/**
 * Created by caoling on 16/6/6.
 */
public class T173 {

    //TODO

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return false;
        }

        /** @return the next smallest number */
        public int next() {
            if (right != null) {
                TreeNode t = right;
                while (t.left != null) {
                    t = t.left;
                }
                return t.val;
            }
            return 0;
        }
    }


}
