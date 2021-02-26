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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return ret;
        
        traverse(root);
        
        return ret;
    }
    
    public int[] traverse(TreeNode cur) {
        if (cur == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = traverse(cur.left);
        int[] right = traverse(cur.right);
        if (left[2] == -1 || left[1] >= cur.val) {
            return new int[]{0, 0, -1};
        }
        if (right[2] == -1 || right[0] <= cur.val) {
            return new int[]{0, 0, -1};
        }
        
        ret = Math.max(ret, right[2] + left[2] + 1);
        
        return new int[]{Math.min(cur.val, left[0]), Math.max(cur.val, right[1]), right[2] + left[2] + 1};
    }
}
