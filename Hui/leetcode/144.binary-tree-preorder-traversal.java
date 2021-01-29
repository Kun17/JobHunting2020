/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        if(root == null) {
            return ret;
        }

        stk.push(root);

        while(stk.size() > 0) {
            TreeNode cur = stk.pop();
            ret.add(cur.val);
            if(cur.right != null) {
                stk.push(cur.right);
            }
            if(cur.left != null) {
                stk.push(cur.left);
            }
        }

        return ret;
    }
}
// @lc code=end

