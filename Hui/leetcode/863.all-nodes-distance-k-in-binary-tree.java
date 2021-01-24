/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ret = new ArrayList<Integer>();
        numChildOfDepth(target, K, ret);
        if (K > 0) {
            findTarget(root, target, K, ret);
        }
        return ret;
    }

    public int findTarget(TreeNode root, TreeNode target, int K, List<Integer> ret) {
        if(root == null) {
            return -1;
        }
        if(root == target) {
            return 1;
        }

        int leftDist = findTarget(root.left, target, K, ret);
        if(leftDist != -1 && leftDist < K) {
            numChildOfDepth(root.right, K - leftDist - 1, ret);
        }

        int rightDist = findTarget(root.right, target, K, ret);
        if(rightDist != -1 && rightDist < K) {
            numChildOfDepth(root.left, K - rightDist - 1, ret);
        }
        
        if(leftDist == K || rightDist == K) {
            ret.add(root.val);
        }

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }
        // System.out.println(rightDist == K);
        // System.out.println("root.val = " + root.val + " leftD = " + leftDist + " rightD = " + rightDist);
        return Math.max(leftDist, rightDist) + 1;
    }

    public void numChildOfDepth(TreeNode root, int d, List<Integer> ret) {
        if(root == null) {
            return;
        }

        if(d == 0) {
            ret.add(root.val);
        } else {
            numChildOfDepth(root.left, d - 1, ret);
            numChildOfDepth(root.right, d - 1, ret);
        }
    }
    //[0,1,null,3,2]\n2\n1
}
// @lc code=end

