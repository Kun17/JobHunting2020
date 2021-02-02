import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayDeque;

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
    // To store the results
    List<List<TreeNode>> paths = new LinkedList<>();
    TreeNode p, q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // So this is actually the 1st node p and q share when they try to reach the root
        // including themselves
        // like p is 5-3, q is 4-2-5-3, find the common 5-3 and get the 1st node
        // So it's DFS
        // So we need to pass the route we have walk to a certain node everytime we reach it
        // if it hits our target, we store it in the res

        // To pass down the path to recursive func
        LinkedList<TreeNode> path = new LinkedList<>();
        this.p = p;
        this.q = q;
        findNStorePath(root, path);
        return findTheLastCommonNode();
    }

    void findNStorePath(TreeNode root, LinkedList<TreeNode> path){
        if(root == null) return;
        path.add(root);
        if(root == p || root == q){
            LinkedList<TreeNode> pathCopy = new LinkedList<TreeNode>(path);
            paths.add(pathCopy);
        }
        findNStorePath(root.left, path);
        findNStorePath(root.right, path);
        path.removeLast();
    }

    TreeNode findTheLastCommonNode(){
        List<TreeNode> pPath = paths.get(0);
        List<TreeNode> qPath = paths.get(1);
        Iterator<TreeNode> pIt = pPath.iterator();
        Iterator<TreeNode> qIt = qPath.iterator();
        TreeNode pNode = pIt.next();
        TreeNode qNode = qIt.next();
        TreeNode pre = pNode;
        while(pIt.hasNext() && qIt.hasNext()){
            pNode = pIt.next();
            qNode = qIt.next();
            if(!pNode.equals(qNode)) return pre;
            pre = pNode;
        }
        return pre;
    }

    public TreeNode lowestCommonAncestor_Traverse(TreeNode root, TreeNode p, TreeNode q){
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        stack.push(root);
        parents.put(root,null);
        while(!parents.containsKey(p) || !parents.containsKey(q)){
            TreeNode curNode = stack.poll();
            if(curNode.left != null) {
                stack.push(curNode.left);
                parents.put(curNode.left, curNode);
            }
            if(curNode.right != null) {
                stack.push(curNode.right);
                parents.put(curNode.right, curNode);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = parents.get(p);
        }

        while(!set.contains(q)){
            q = parents.get(q);
        }
        return q;
    }

    // How to make the original function the best
    public TreeNode lowestCommonAncestor_Shortest(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if(right == null){
            return left;
        } else {
            return root;
        }
    }
}