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
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
    int count = 0;
    Map<Integer, Integer> map;
    int sum;
    public int pathSum(TreeNode root, int sum) {
    //Thought is, if sum = 8, root = 5, rootLeft need to test 8 and 3, so does root right
    // it goes on, we can use set to make check O(1) time.
    // So it's basically DFS
    // time complexity should be O(log(n))
    // space complexity should be O(n)
        this.sum = sum;
        map = new HashMap<>();
        int prefixSum = 0;
        dfs(root, prefixSum);
        return count;
    }

    private void dfs(TreeNode root, int prefixSum){
        if(root == null) return;
        prefixSum += root.val;
        if(map.containsKey(prefixSum - sum)) count += map.get(prefixSum - sum);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        dfs(root.left, prefixSum);
        dfs(root.right, prefixSum);
        map.put(prefixSum, map.get(prefixSum)-1);
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
        String[] vals = new String[]{"10","5","-3","3","2","null","11","3","-2","null","1"};
        TreeNode root = s.constructTree(vals);
        System.out.println(s.pathSum(root, 8));
    }
}