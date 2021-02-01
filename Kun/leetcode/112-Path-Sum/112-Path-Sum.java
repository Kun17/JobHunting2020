import java.util.Deque;
import java.util.ArrayDeque;
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
    public boolean hasPathSum_recursion(TreeNode root, int targetSum) {
        if (root == null) return targetSum == 0;
        if(root.left == null) {
            if(root.right != null) return hasPathSum_recursion(root.right, targetSum - root.val);
            return root.val == targetSum;
        } else if (root.right == null){
            return hasPathSum_recursion(root.left, targetSum - root.val);
        } else {
            return hasPathSum_recursion(root.right, targetSum - root.val) || hasPathSum_recursion(root.left, targetSum - root.val);
        }
    }

    //Try not to use recursion
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return targetSum == 0;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> sumStack = new ArrayDeque<>();
        int sum = 0;
        boolean result = false;
        nodeStack.push(root);
        sumStack.push(root.val);
        while(!nodeStack.isEmpty()){
            TreeNode curNode = nodeStack.poll();
            sum = sumStack.poll();
            if (curNode.left != null) {
                nodeStack.push(curNode.left);
                sumStack.push(sum + curNode.left.val);
            }
            if (curNode.right != null) {
                nodeStack.push(curNode.right);
                sumStack.push(sum + curNode.right.val);
            }
            if (curNode.left == null && curNode.right == null) {
                result = result || (sum == targetSum);
            }
        }
        return result;
    }
}