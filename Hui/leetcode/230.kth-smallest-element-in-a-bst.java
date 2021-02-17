/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stk.push(node);
            
            node = node.left;
        }

        while (k > 1) {
            k--;
            TreeNode cur = stk.pop();
            cur = cur.right;
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
        }

        return stk.pop().val;
    }
}
// @lc code=end

