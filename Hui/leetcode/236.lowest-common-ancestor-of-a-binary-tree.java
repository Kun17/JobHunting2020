/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findTarget(root, p, q);
        return result;
    }

    public boolean findTarget(TreeNode root, TreeNode p, TreeNode q) {
        if(result != null || root == null) {
            return false;
        }
        
        boolean equal = false;
        if(root.val == p.val || root.val == q.val) {
            equal = true;
        }

        boolean left = findTarget(root.left, p, q);
        boolean right = findTarget(root.right, p, q);

        if(left && right) {
            result = root;
        } else if(left && equal) {
            result = root;
        } else if(right && equal) {
            result = root;
        }

        return equal || left || right;
    }
}
// @lc code=end

