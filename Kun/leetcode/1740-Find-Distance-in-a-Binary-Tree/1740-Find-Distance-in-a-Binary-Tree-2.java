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
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
// time complexity: O(N)
// space complexity: O(log(N))
class Solution {
    int res = 0;
    public int findDistance(TreeNode root, int p, int q) {
        // we 1st find the lowest common parent
        // we can use dfs to construct parent map 1st
        return dfs(root, p, q);
    }

    private int dfs(TreeNode root, int p, int q){
        if(root == null) return -1;
        int left = dfs(root.left, p , q);
        int right = dfs(root.right, p, q);
        if(root.val == p || root.val == q){
            if(left < 0 && right < 0) return 0;
            if(left >= 0) res = left+1;
            if(right >= 0) res = right + 1;
        }
        if(left >= 0 && right >= 0) res = left + right + 2;
        if(left >= 0) return left + 1;
        if(right >= 0) return right + 1;
        return -1;
    }
}