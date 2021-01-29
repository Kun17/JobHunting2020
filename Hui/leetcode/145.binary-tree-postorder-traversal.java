/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        List<Integer> ret = new ArrayList<Integer>();
        TreeNode prev = null;
        if(root != null) {
            stk.push(root);
        }
        while(stk.size() > 0) {
            TreeNode cur = stk.peek();
            if(prev == null || cur == prev.left || cur == prev.right) {
                if(cur.left != null) {
                    stk.push(cur.left);
                } else if(cur.right != null) {
                    stk.push(cur.right);
                } else {
                    stk.pop();
                    ret.add(cur.val);
                }
            } else if(cur.left == prev) {
                if(cur.right != null) {
                    stk.push(cur.right);
                } else {
                    stk.pop();
                    ret.add(cur.val);
                }
            } else {
                stk.pop();
                ret.add(cur.val);
            }
            prev = cur;
        }

        return ret;
        // Stack<TreeNode> stk1 = new Stack<TreeNode>();
        // Stack<TreeNode> stk2 = new Stack<TreeNode>();

        // List<Integer> ret = new ArrayList<Integer>();
        // if(root != null) {
        //     stk1.push(root);
        // }

        // while(stk1.size() > 0) {
        //     TreeNode cur = stk1.pop();
        //     stk2.push(cur);

        //     if(cur.left != null) {
        //         stk1.push(cur.left);
        //     }
        //     if(cur.right != null) {
        //         stk1.push(cur.right);
        //     }
        // }

        // while(stk2.size() > 0) { 
        //     ret.add(stk2.pop().val);
        // }
        // return ret;
    }
}
// @lc code=end

