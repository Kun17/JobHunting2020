/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        while(root != null) {
            stk.push(root);
            root = root.left;
        }

        List<Integer> ret = new ArrayList<Integer>();
        while(stk.size() > 0) {
            TreeNode cur = stk.pop();
            ret.add(cur.val);
            cur = cur.right;
            while(cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
        }

        return ret;
    }
}
// @lc code=end

