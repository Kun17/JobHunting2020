/*
 * @lc app=leetcode id=1305 lang=java
 *
 * [1305] All Elements in Two Binary Search Trees
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Iterator i1 = new Iterator(root1);
        Iterator i2 = new Iterator(root2);

        List<Integer> ret = new ArrayList<Integer>();
        while (i1.peek() != Integer.MAX_VALUE && i2.peek() != Integer.MAX_VALUE) {
            if (i1.peek() < i2.peek()) {
                ret.add(i1.next());
            } else {
                ret.add(i2.next());
            }
        }

        while (i1.peek() != Integer.MAX_VALUE) {
            ret.add(i1.next());
        }

        while (i2.peek() != Integer.MAX_VALUE) {
            ret.add(i2.next());
        }

        return ret;
    }

    class Iterator {
        Stack<TreeNode> stk;
        public Iterator(TreeNode root) {
            stk = new Stack<TreeNode>();
            TreeNode cur = root;
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
        }

        public int peek() {
            if (stk.size() == 0) {
                return Integer.MAX_VALUE;
            }
            return stk.peek().val;
        }

        public int next() {
            TreeNode cur = stk.pop();
            int ret = cur.val;
            cur = cur.right;
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            return ret;
        }
    }
}
// @lc code=end

