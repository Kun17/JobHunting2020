/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        } 
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int ps, int[] inorder, int is, int ie) {
        if (is > ie) {
            return null;
        }
        if (is == ie) {
            return new TreeNode(inorder[is]);
        }

        int rootIdx = map.get(preorder[ps]);

        TreeNode root = new TreeNode(preorder[ps]);
        root.left = helper(preorder, ps + 1, inorder, is, rootIdx - 1);
        root.right = helper(preorder, ps + (rootIdx - is) + 1, inorder, rootIdx + 1, ie);

        return root;
    }
}
// @lc code=end

