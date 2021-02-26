/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        Node ret = null;
        if (node.right != null) {
            ret = node.right;
            while (ret.left != null) {
                ret = ret.left;
            }
        } else {
            ret = node.parent;
            while (ret != null && ret.val < node.val) {
                ret = ret.parent;
            }
        }
        return ret;
    }
}
