/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(root, targetSum, new ArrayList<Integer>(), ret);
        return ret;
    }

    public void helper(TreeNode root, int target, ArrayList<Integer> tmp, List<List<Integer>> ret) {
        if(root == null) return;
        if(root.left == null && root.right == null && root.val == target) {
            tmp.add(root.val);
            ret.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }

        tmp.add(root.val);
        helper(root.left, target - root.val, tmp, ret);
        helper(root.right, target - root.val, tmp, ret);
        tmp.remove(tmp.size() - 1);
    }
}
// @lc code=end

