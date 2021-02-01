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
    int maxValue;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxValue = Integer.MIN_VALUE;

        maxPathDown(root);
        return maxValue;
    }

    int maxPathDown(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            maxValue = Math.max(maxValue, root.val);
            return root.val;
        }
        int l = Math.max(maxPathDown(root.left), 0);
        int r = Math.max(maxPathDown(root.right), 0);
        maxValue = Math.max(maxValue, root.val + l + r);

        return root.val + Math.max(l, r);
    }
}