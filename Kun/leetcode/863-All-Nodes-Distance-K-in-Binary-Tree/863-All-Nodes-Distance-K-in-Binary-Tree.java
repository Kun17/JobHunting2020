import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Queue;

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
class Solution {
    List<Integer> res;
    Set<TreeNode> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // search for target, and store all the parents during the path
        // using dfs
        List<TreeNode> parentPath = new ArrayList<>();
        parentPath = dfs(root, target, parentPath);
        res = new ArrayList<>();
        int len = parentPath.size();
        visited = new HashSet<>();
        for(int i = len-1; i >=0; i--){
            if(K - len + 1 + i >= 0){
                TreeNode cur = parentPath.get(i);
                findDistanceNodeFromRoot(cur, K - len + 1 + i);
            }
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

    private List<TreeNode> dfs(TreeNode root, TreeNode target, List<TreeNode> parentPath){
        if(root == null) return null;
        parentPath.add(root);
        if(root.val == target.val) return parentPath;
        List<TreeNode> left = dfs(root.left, target, parentPath);
        if(left != null) return left;
        List<TreeNode> right = dfs(root.right, target, parentPath);
        if(right != null) return right;
        parentPath.remove(parentPath.size() - 1);
        return null;
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
        String[] vals = new String[]{"3","5","1","6","2","0","8","null","null","7","4"};
        String[] targetVals = new String[]{"5","6","2","null","null","7","4"};
        TreeNode root = s.constructTree(vals);
        TreeNode target = s.constructTree(targetVals);
        System.out.println(s.distanceK(root, target, 2));
    }
}