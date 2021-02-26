/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret, 0);
        return ret;
    }

    public void traverse(TreeNode root, List<Integer> ret, int level) {
        if (root == null) return;
        if (ret.size() == level) {
            ret.add(root.val);
        } else if (ret.get(level) < root.val){
            ret.set(level, root.val);
        }   

        traverse(root.left, ret, level + 1);
        traverse(root.right, ret, level + 1);
    }
}
// @lc code=end

