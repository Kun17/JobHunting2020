/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
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
    public int maxLevelSum(TreeNode root) {
        int ret = 0;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int level = 0;
        while(queue.size() > 0) {
            // indicate the current level
            level++;
            // length of the current level
            int len = queue.size();
            // sum of the current level
            int levelSum = 0;
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            if(maxSum < levelSum) {
                maxSum = levelSum;
                ret = level;
            }
        }
        return ret;
    }
}
// @lc code=end

