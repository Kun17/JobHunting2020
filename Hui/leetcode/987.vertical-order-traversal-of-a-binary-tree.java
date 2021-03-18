/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        helper(root, 0, 0, map);;
        List<List<Integer>> ret = new ArrayList<>();
        for (int k: map.keySet()) {
            Collections.sort(map.get(k), new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
            });
            List<Integer> subret = new ArrayList<>();
            for (int[] v: map.get(k)) {
                subret.add(v[1]);
            }
            ret.add(subret);
        }
        return ret;
    }

    public void helper(TreeNode root, int row, int col, Map<Integer, List<int[]>> map) {
        if (root == null) return;
        if (!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
        }
        map.get(col).add(new int[]{row, root.val});
        helper(root.left, row + 1, col - 1, map);
        helper(root.right, row + 1, col + 1, map);
    }
}
// @lc code=end

