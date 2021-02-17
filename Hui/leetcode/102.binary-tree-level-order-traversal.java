/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    List<List<Integer>> ret;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ret = new ArrayList<List<Integer>>();
        traverse(root, 0);
        return ret;
    }

    public void traverse(TreeNode root, int level) {
        if (root == null) return;
        if (level == ret.size()) {
            ret.add(new ArrayList<Integer>());
        }

        ret.get(level).add(root.val);
        
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}
// @lc code=end

