/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stk.push(cur);
            cur = cur.right;
        }

        int sum = 0;
        while (stk.size() > 0) {
            cur = stk.pop();
            sum = sum + cur.val;
            cur.val = sum;
            cur = cur.left;
            while (cur != null) {
                stk.push(cur);
                cur = cur.right;
            }
        }

        return root;
    }
}
// @lc code=end

