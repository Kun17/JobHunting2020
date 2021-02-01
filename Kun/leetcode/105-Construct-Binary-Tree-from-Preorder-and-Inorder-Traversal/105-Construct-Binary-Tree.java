import java.util.HashMap;
import java.util.Map;

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
    // We use recursion, everytime we can get the root from the preorder arr
    // using remaining inorder array to find the left and right tree, then 
    // Till only one root and 2 leaves, this is the recursion

    // To find the location of root on the indorder arr, we use a hashmap to store value-pos pair
    // Note every node is treated as root in preorder, so does to in order
    // this means we need to recurse to left and right equals null

    int rootPrePos = 0;
    Map<Integer, Integer> valPosMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            valPosMap.put(inorder[i],i);
        }
        return buildTreeHelper(preorder, inorder, 0, inorder.length-1);
    }

    TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inS, int inE){
        //Get the root val
        if(inS > inE) return null;
        int rootVal = preorder[rootPrePos];
        rootPrePos++;
        if(inS == inE) return new TreeNode(inorder[inS]);
        int rootInPos = valPosMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, inorder, inS, rootInPos-1);
        root.right = buildTreeHelper(preorder, inorder, rootInPos+1, inE);
        return root;
    }
}