/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        TreeNode cur = root;        
        int height = 0;
        while(cur != null) {
            height++;
            cur = cur.left;
        }

        int count = 0;
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ++count;
                break;
            }
            int tHeight = 0;
            TreeNode temp = cur.left;
            while (temp != null) {
                tHeight++;
                temp = temp.right;
            }
            count += 1 << tHeight;
            if (tHeight == height - 1) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
            height--;
        }
        return count;
    }

    /*
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        TreeNode cur = root;        
        int leftH = 0;
        while(cur != null) {
            leftH++;
            cur = cur.left;
        }

        int rightH = 0;
        cur = root;
        while(cur != null) {
            rightH++;
            cur = cur.right;
        }
        int count = 0;
        if(leftH == rightH) {
            count = (1 << leftH) - 1;
        } else {
            count = countNodes(root.left) + countNodes(root.right) + 1;
        }

        return count;
    }
    */
}
// @lc code=end

