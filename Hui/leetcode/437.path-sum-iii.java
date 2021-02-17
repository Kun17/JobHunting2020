/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
        sums.put(0, 1);
        helper(root, sums, 0, sum);
        return ret;
    }

    public void helper(TreeNode root, Map<Integer, Integer> map, int cur, int target) {
        if (root == null) return;

        cur += root.val;
        ret += map.getOrDefault(cur - target, 0);

        map.put(cur, map.getOrDefault(cur, 0) + 1);
        helper(root.left, map, cur, target);
        helper(root.right, map, cur, target);
        if (map.get(cur) == 1) {
            map.remove(cur);
        } else {
            map.put(cur, map.get(cur) - 1);
        }
    }
}
// @lc code=end

