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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        ret.add(root.val);
        findLeft(root.left, ret);
        findLeaf(root.left, ret);
        findLeaf(root.right, ret);
        findRight(root.right, ret);
        return ret;
        
    }
    
    public void findLeft(TreeNode root, List<Integer> left) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            left.add(root.val);
        }
        if (root.left != null) {
            findLeft(root.left, left);
        } else if (root.right != null) {
            findLeft(root.right, left);
        }
    }
    
    public void findLeaf(TreeNode root, List<Integer> leaf) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
        }
        if (root.left != null) {
            findLeaf(root.left, leaf);
        }
        if (root.right != null) {
            findLeaf(root.right, leaf);
        }
    }
    
    public void findRight(TreeNode root, List<Integer> right) {
        if (root == null) return;
        
        if (root.right != null) {
            findRight(root.right, right);
        } else if (root.left != null) {
            findRight(root.left, right);
        }
        if (root.left != null || root.right != null) {
            right.add(root.val);
        }
    }
}
