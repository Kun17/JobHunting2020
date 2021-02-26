/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> hash = new HashMap<>();
        traverse(root, hash);
        List<TreeNode> ret = new ArrayList<>();
        for (String key: hash.keySet()) {
            if (hash.get(key).size() > 1) {
                ret.add(hash.get(key).get(0));
            }
        }

        return ret;
    }

    public String traverse(TreeNode root, Map<String, List<TreeNode>> hash) {
        if (root == null) return "#";

        StringBuilder sb = new StringBuilder();
        String left = traverse(root.left, hash);
        String right = traverse(root.right, hash);

        sb.append(left);
        sb.append("-");
        sb.append(right);
        sb.append("-");
        sb.append(root.val);

        String key = sb.toString();
        if (hash.containsKey(key)) {
            hash.get(key).add(root);
        } else {
            hash.put(key, new ArrayList<>(Arrays.asList(root)));
        }
        return key;
    }
}
// @lc code=end

