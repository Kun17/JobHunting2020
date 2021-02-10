/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int pe) {
        // System.out.println(is + " " + ie + " " + pe);
        if (is > ie) {
            return null;
        }

        if (is == ie) {
            return new TreeNode(inorder[is]);
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int idx = map.get(postorder[pe]);

        root.left = helper(inorder, is, idx - 1, postorder,pe - (ie - idx) - 1);
        root.right = helper(inorder, idx + 1, ie, postorder, pe - 1);

        return root;
    }
    //[3,2,1]\n[3,2,1]
    //[-4,-10,3,-1,7,11,-8,2]\n[-4,-1,3,-10,11,-8,2,7]
}
// @lc code=end

