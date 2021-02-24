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
    TreeNode commonP;
    public int findDistance(TreeNode root, int p, int q) {
        // we 1st find the lowest common parent
        // we can use dfs to construct parent map 1st
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        parentMap.put(root, null);
        stack.push(root);
        TreeNode pNode = null;
        TreeNode qNode = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.val == p) pNode = cur;
            if(cur.val == q) qNode = cur;
            if(cur.left != null){
                parentMap.put(cur.left, cur);
                stack.push(cur.left);
            }
            if(cur.right != null){
                parentMap.put(cur.right, cur);
                stack.push(cur.right);
            }
            if(pNode != null && qNode != null) break;
        }
        Set<TreeNode> path = new HashSet<>();
        TreeNode pPNode = pNode;
        while(pPNode != null){
            path.add(pPNode);
            pPNode = parentMap.get(pPNode);
        }
        int count = 0;
        while(!path.contains(qNode)){
            qNode = parentMap.get(qNode);
            count++;
        }

        // p is longer than q
        while(pNode != qNode){
            pNode = parentMap.get(pNode);
            count++;
        }
        return count;
    }
}