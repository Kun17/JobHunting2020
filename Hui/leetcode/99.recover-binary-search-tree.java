/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
     public void recoverTree(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null) {
            stk.push(cur);
            cur = cur.left;
        }
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        TreeNode prev = null;
        while (stk.size() > 0) {
            cur = stk.pop();
            if (prev != null && prev.val > cur.val) {
                nodes.add(prev);
                nodes.add(cur);
            }
            if (nodes.size() == 4) break;
            prev = cur;
            cur = cur.right;
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
        }
        
        if (nodes.size() == 4) {
            swap(nodes.get(0), nodes.get(3));
        } else {
            swap(nodes.get(0), nodes.get(1));
        }
    }
    
    public void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
// @lc code=end

