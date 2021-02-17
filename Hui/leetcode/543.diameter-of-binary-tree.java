/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return ret;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int cur = 0;
        int left = traverse(root.left);
        int right = traverse(root.right);

        ret = Math.max(ret, left + right);
        return Math.max(left, right) + 1;
    }
}
// @lc code=end

