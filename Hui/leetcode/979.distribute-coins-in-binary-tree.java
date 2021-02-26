/*
 * @lc app=leetcode id=979 lang=java
 *
 * [979] Distribute Coins in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ret = 0;
    public int distributeCoins(TreeNode root) {
        traverse(root);
        return ret;
    }

    public int[] traverse(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        ret = ret + Math.abs(left[0] - left[1]);
        ret = ret + Math.abs(right[0] - right[1]);

        return new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1}; 
    }
}
// @lc code=end

