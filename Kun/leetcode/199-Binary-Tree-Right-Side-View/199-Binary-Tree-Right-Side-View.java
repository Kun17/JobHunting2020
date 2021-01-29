import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
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
    class Node {
        int pos;
        int val;
        Node(int pos, int val){this.pos = pos; this.val = val;}
    }
    // This is actually a problem to find the rightmost node of every depth
    // The most intuitive approach is use DAC or recursion
    // if we can pass down the x position of every layer, like left --, right ++
    public List<Integer> rightSideView(TreeNode root) {
        List<Node> data = findTheRightMostNode(root, 0);
        List<Integer> res = new ArrayList<>();
        for (Node n: data){
            res.add(n.val);
        }
        return res;
    }

    List<Node> findTheRightMostNode(TreeNode parent, int parentPos){
        if(parent == null) return null;
        if(parent.right == null && parent.left == null) return new ArrayList<>(Arrays.asList(new Node(parentPos, parent.val)));
        List<Node> l = findTheRightMostNode(parent.left, parentPos * 2 + 1);
        List<Node> r  = findTheRightMostNode(parent.right, parentPos * 2 + 2);
        List<Node> res = new ArrayList<>();
        res.add(new Node(parentPos, parent.val));
        res.addAll(merge(l, r));
        return res;
    }

    List<Node> merge(List<Node> ls, List<Node> rs){
        if (ls == null) return rs;
        if (rs == null) return ls;
        int lN = ls.size(), rN = rs.size();
        int lIdx = 0, rIdx = 0;
        List<Node> res = new ArrayList<>();
        while (lIdx < lN || rIdx < rN){
            Node l = (lIdx < lN)? ls.get(lIdx): null;
            Node r = (rIdx < rN)? rs.get(rIdx): null;
            if(l == null || r !=  null && l.pos < r.pos) {
                res.add(new Node(r.pos, r.val));
            } else {
                res.add(new Node(l.pos, l.val));
            }
            lIdx++;
            rIdx++;
        }
        return res;
    }

    TreeNode constructTree(String[] vals){
        if(vals.length == 0) return null;
        int idx = 0;
        TreeNode root = new TreeNode(Integer.valueOf(vals[idx++]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        int N = vals.length;

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (idx < N && vals[idx] != "null") {
                TreeNode l = new TreeNode(Integer.valueOf(vals[idx]));
                curNode.left = l;
                queue.add(l);
            }
            idx++;
            if (idx < N && vals[idx] != "null") {
                TreeNode r = new TreeNode(Integer.valueOf(vals[idx]));
                curNode.right = r;
                queue.add(r);
            }
            idx++;
        }
        return root;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        String[] vals = new String[]{"1","2","3","null","5","null","4"};
        TreeNode root = s.constructTree(vals);
        List<Integer> res = s.rightSideView(root);
        for (Integer i: res){
            System.out.println(i);
        }
    }
}