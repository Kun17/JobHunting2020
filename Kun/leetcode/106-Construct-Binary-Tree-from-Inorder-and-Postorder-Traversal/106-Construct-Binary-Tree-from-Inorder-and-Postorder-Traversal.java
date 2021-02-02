import java.util.HashMap;

import java.util.Map;
import java.util.HashMap;
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
    int[] inorder, postorder;
    Map<Integer, Integer> posValMap = new HashMap<>();
    int postPtr;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.postPtr = postorder.length-1;
        for(int i = 0; i < inorder.length; i++){
            posValMap.put(inorder[i],i);
        }
        return buildTreeHelper(0, inorder.length-1);
    }

    TreeNode buildTreeHelper(int s, int e){
        if(s > e) return null;
        int rootVal = this.postorder[this.postPtr--];
        TreeNode root = new TreeNode(rootVal);
        int mid = posValMap.get(rootVal);
        root.right = buildTreeHelper(mid + 1, e);
        root.left = buildTreeHelper(s, mid - 1);
        return root;
    }
}