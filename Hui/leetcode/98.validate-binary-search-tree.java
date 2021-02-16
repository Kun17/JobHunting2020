/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        minMax(root);
        return valid;
    }

    public int[] minMax(TreeNode root) {
        if(!valid) return null;
        if(root == null) {
            return null;
        }
        int[] leftMinMax = minMax(root.left);
        int min = root.val;
        if(leftMinMax != null) {
            if(leftMinMax[1] >= root.val) {
                valid = false;
                return null;
            }
            min = leftMinMax[0];
        }
        int[] rightMinMax = minMax(root.right);
        int max = root.val;
        if(rightMinMax != null) {
            if(rightMinMax[0] <= root.val) {
                valid = false;
                return null;
            }
            max = rightMinMax[1];
        }

        return new int[]{min, max};
    }
}
// @lc code=end

