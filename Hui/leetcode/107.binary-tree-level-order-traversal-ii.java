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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        traverse(root, ret, 0);
        Collections.reverse(ret);
        return ret;
    }
    
    public void traverse(TreeNode root, List<List<Integer>> ret, int level) {
        if (root == null) return;
        if (ret.size() == level) {
            ret.add(new ArrayList<>());
        }
        
        ret.get(level).add(root.val);
        traverse(root.left, ret, level + 1);
        traverse(root.right, ret, level + 1);
        
    }
}
