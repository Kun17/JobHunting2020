/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delete = new HashSet<>();
        for (int d: to_delete) {
            delete.add(d);
        }
        List<TreeNode> ret = new ArrayList<>();
        delete(root, delete, ret, true);
        return ret;
    }

    public boolean delete(TreeNode root, Set<Integer> set, List<TreeNode> ret, boolean prevDeleted) {
        if (root == null) return false;

        boolean deleted = false;
        if (set.contains(root.val)) {
            deleted = true;
        }

        if (prevDeleted && !deleted) {
            ret.add(root);
        }
        boolean leftdelete = delete(root.left, set, ret, deleted);
        boolean rightdelete = delete(root.right, set, ret, deleted);
        if (leftdelete) root.left = null;
        if (rightdelete) root.right = null;
        return deleted;
    }
}
// @lc code=end

