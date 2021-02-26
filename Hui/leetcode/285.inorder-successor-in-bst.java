/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode greater = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traverse(root, p);
        return greater;
    }
    
    public void traverse(TreeNode root, TreeNode p) {
        if (root == null) return;
        if (root.val <= p.val) {
            traverse(root.right, p);
        } else {
            if (greater == null || root.val - p.val < greater.val - p.val) {
                greater = root;
            }
            traverse(root.left, p);
        }
    }
    
//     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//         Stack<TreeNode> stk = new Stack<TreeNode>();
//         TreeNode cur = root;
//         while (cur != null) {
//             stk.push(cur);
//             cur = cur.left;
//         }
        
//         while (stk.size() > 0 && stk.peek().val <= p.val) {
//             cur = stk.pop();
//             cur = cur.right;
//             while (cur != null) {
//                 stk.push(cur);
//                 cur = cur.left;
//             }
//         }
        
//         if (stk.size() == 0) return null;
//         return stk.pop();
//     }
}
