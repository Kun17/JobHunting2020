/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode leftLast = null;
        if (root.left != null) {
            leftLast = helper(root.left);
        }

        TreeNode rightLast = null;
        if (root.right != null) {
            rightLast = helper(root.right);
        }
        
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLast == null) return leftLast;
        return rightLast;
    }
}
// @lc code=end

