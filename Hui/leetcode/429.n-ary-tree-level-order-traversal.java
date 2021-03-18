/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> subret = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                subret.add(cur.val);
                for (Node next: cur.children) {
                    q.add(next);
                }
            }
            ret.add(subret);
        }

        return ret;
    }
}
// @lc code=end

