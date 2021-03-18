/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.left != null) {
            int predecessor = predecessor(root.left);
            root.val = predecessor;
            root.left = deleteNode(root.left, predecessor);
        } else if (root.right != null) {
            int successor = successor(root.right);
            root.val = successor;
            root.right = deleteNode(root.right, successor);
        } else {
            root = null;
        }
        return root;
    }

    public int predecessor(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public int successor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
// @lc code=end

