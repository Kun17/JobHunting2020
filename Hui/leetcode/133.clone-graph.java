/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        map.put(node.val, new Node(node.val));

        while(q.size() > 0) {
            Node cur = q.poll();
            Node copy = map.get(cur.val);
            for(Node next : cur.neighbors) {
                if(!map.containsKey(next.val)) {
                    q.add(next);
                    map.put(next.val, new Node(next.val));
                }
                copy.neighbors.add(map.get(next.val));
            }
        }

        return map.get(1);
    }
}
// @lc code=end

