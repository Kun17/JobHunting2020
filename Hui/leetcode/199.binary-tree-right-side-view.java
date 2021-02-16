/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    List<Integer> ret;
    public List<Integer> rightSideView(TreeNode root) {
        ret = new ArrayList<Integer>();
        traverse(root, 1);
        return ret;
    }

    public void traverse(TreeNode node, int level) {
        if(node == null) {
            return;
        } 

        if(ret.size() < level) {
            ret.add(node.val);
        }
        traverse(node.right, level + 1);
        traverse(node.left, level + 1);
    }
}
// @lc code=end

