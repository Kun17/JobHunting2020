import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // time complexity: O(N)
 // space complexity: O(N)
class Solution2 {
    List<Integer> res;
    Set<TreeNode> visited;
    Map<TreeNode, TreeNode> parentMap;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // search for target, and store all the parents during the path
        // using dfs
        parentMap = new HashMap<>();
        dfs(root, null);
        res = new ArrayList<>();
        visited = new HashSet<>();
        TreeNode curNode = target;
        int count = 0;
        while(curNode != null){
            if(K - count < 0) break;
            findDistanceNodeFromRoot(curNode, K - count);
            curNode = parentMap.get(curNode);
            count++;
        }
        return res;
    }

    private void findDistanceNodeFromRoot(TreeNode cur, int distance){
        if(cur == null) return;
        if(visited.contains(cur)) return;
        visited.add(cur);
        if(distance == 0) res.add(cur.val);
        findDistanceNodeFromRoot(cur.left, distance-1);
        findDistanceNodeFromRoot(cur.right, distance-1);
    }

    private void dfs(TreeNode child, TreeNode parent){
        if(child == null) return;
        this.parentMap.put(child, parent);
        dfs(child.left, child);
        dfs(child.right, child);
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
        Solution2 s = new Solution2();
        String[] vals = new String[]{"3","5","1","6","2","0","8","null","null","7","4"};
        String[] targetVals = new String[]{"5","6","2","null","null","7","4"};
        TreeNode root = s.constructTree(vals);
        TreeNode target = s.constructTree(targetVals);
        System.out.println(s.distanceK(root, target, 2));
    }
}