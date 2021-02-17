/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    List<TreeNode>[][] trees;
    public List<TreeNode> generateTrees(int n) {
        trees = new List[n + 1][n + 1];

        generate(1, n);
        return trees[1][n];
    }

    public List<TreeNode> generate(int s, int e) {
        
        if (s > e) {
            List<TreeNode> ret = new ArrayList<TreeNode>();
            ret.add(null);
            return ret;
        }
        if (trees[s][e] != null) {
            return trees[s][e];
        }

        if (s == e) {
            trees[s][e] = Arrays.asList(new TreeNode(s));
        } else {
            trees[s][e] = new ArrayList<TreeNode>();
            for (int i = s; i <= e; i++) {
                List<TreeNode> left = generate(s, i - 1);
                List<TreeNode> right = generate(i + 1, e);
                for (TreeNode l: left) {
                    for (TreeNode r: right) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = l;
                        cur.right = r;
                        trees[s][e].add(cur);
                    }
                }
            }
        }

        return trees[s][e];
    }
}
// @lc code=end

