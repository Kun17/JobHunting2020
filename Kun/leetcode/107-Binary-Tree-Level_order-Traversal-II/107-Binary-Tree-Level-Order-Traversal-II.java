import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrderBottom_traverse(TreeNode root) {
        // Using sentinel and stack
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        q.add(root);
        q.add(null);
        List<Integer> ans =  new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            if(curNode == null) {
                List<Integer> copy = new LinkedList<>(ans);
                result.add(0, copy);
                ans.clear();
                if(!q.isEmpty()) q.add(null);
                continue;
            }
            ans.add(curNode.val);
            if(curNode.left != null) {
                q.add(curNode.left);
            }
            if(curNode.right != null) {
                q.add(curNode.right);
            }
        }
        return result;
    }

    // Try use recursion
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root, 0);
        Collections.reverse(res);
        return res;
    }

    void helper(TreeNode root, int level){
        if(root == null) return;

        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(root.val);
        if(root.left != null) helper(root.left, level + 1);
        if(root.right != null) helper(root.right, level + 1);
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
        String[] vals = new String[]{"3","9","20","null","15","7"};
        TreeNode root = s.constructTree(vals);
        List<List<Integer>> ress = s.levelOrderBottom(root);
        for(List<Integer> res: ress){
            System.out.println(res.toString());
        }
    }
}