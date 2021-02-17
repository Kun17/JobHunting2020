/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ret = new ArrayList<List<Integer>>();
        traverse(root, 0);
        for (int i = 0; i < ret.size(); i++) {
            if (i % 2 == 0) continue;
            Collections.reverse(ret.get(i));
        }
        return ret;
    }

    public void traverse(TreeNode root, int level) {
        if (root == null) return;

        if (ret.size() == level) {
            ret.add(new ArrayList<Integer>());
        }

        ret.get(level).add(root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}
// @lc code=end

