/*
 * @lc app=leetcode id=1145 lang=java
 *
 * [1145] Binary Tree Coloring Game
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
    int numXLeft = 0, numXRight = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        helper(root, x);

        int numXTotal = numXLeft + numXRight + 1;
        // System.out.println("numXTotal = " + numXTotal);
        // System.out.println("left = " + numXLeft);
        // System.out.println("right = " + numXRight);
        boolean parentWin = (2 * numXTotal < n);
        boolean leftWin = (2 * numXLeft > n);
        boolean rightWin = (2 * numXRight > n);

        return parentWin || leftWin || rightWin;
    }

    public int helper(TreeNode root, int x) {
        if(root == null) return 0;

        int left = helper(root.left, x);
        int right = helper(root.right, x);
        if(root.val == x) {
            numXLeft = left;
            numXRight = right;
        }

        return left + right + 1;
    }

    
}
// [1,2,3,4,5]\n5\n1\n
// @lc code=end

