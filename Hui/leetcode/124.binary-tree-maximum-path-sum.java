/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSums(root);
        return maxSum;
    }

    public int[] maxSums(TreeNode root) {
        int curMaxSum = root.val;
        int[] sums = new int[]{root.val, root.val};
        if(root.left != null) {
            int[] leftSums = maxSums(root.left);
            int leftMax = Math.max(root.val, root.val + leftSums[0]);
            leftMax = Math.max(leftMax, root.val + leftSums[1]);
            curMaxSum = Math.max(curMaxSum, leftMax);
            sums[0] = Math.max(sums[0], leftMax);
        }
        if(root.right != null) {
            int[] rightSums = maxSums(root.right);
            int rightMax = Math.max(root.val, root.val + rightSums[0]);
            rightMax = Math.max(rightMax, root.val + rightSums[1]);
            curMaxSum = Math.max(curMaxSum, rightMax);
            sums[1] = Math.max(sums[1], rightMax);
        }

        curMaxSum = Math.max(curMaxSum, sums[0] + sums[1] - root.val);
        maxSum = Math.max(maxSum, curMaxSum);
        return sums;
    }
    // [1,2,null,3,null,4,null,5]\n
}
// @lc code=end

