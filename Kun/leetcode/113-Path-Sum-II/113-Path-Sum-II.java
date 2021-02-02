import java.util.Deque;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> pathSum_non_recursion(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> sumStack = new ArrayDeque<>();
        // Using a hashMap to store child and its parent
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        nodeStack.push(root);
        sumStack.push(root.val);
        while(!nodeStack.isEmpty()){
            TreeNode curNode = nodeStack.poll();
            sum = sumStack.poll();
            if (curNode.left != null) {
                nodeStack.push(curNode.left);
                sumStack.push(sum + curNode.left.val);
                childParentMap.put(curNode.left, curNode);
            }
            if (curNode.right != null) {
                nodeStack.push(curNode.right);
                sumStack.push(sum + curNode.right.val);
                childParentMap.put(curNode.right, curNode);
            }
            if (curNode.left == null && curNode.right == null) {
                if(sum == targetSum) {
                    Deque<Integer> ansStack = new ArrayDeque<>();
                    ansStack.push(curNode.val);
                    while(childParentMap.containsKey(curNode)){
                        curNode = childParentMap.get(curNode);
                        ansStack.push(curNode.val);
                    }
                    List<Integer> ans = new ArrayList<>();
                    while(!ansStack.isEmpty()){
                        ans.add(ansStack.poll());
                    }
                    result.add(ans);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> pathSum_Recursion(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        if(root.left == null) {
            if(root.right == null) {
                List<List<Integer>> res = new ArrayList<>();
                if (targetSum == root.val) {
                    List<Integer> ele = new ArrayList<>();
                    ele.add(root.val);
                    res.add(ele);
                }
                return res;
            }
            List<List<Integer>> subResR = pathSum_Recursion(root.right, targetSum - root.val);
            for( List<Integer> l : subResR) {
                if(l.size() > 0) l.add(0, root.val);
            }
            return subResR;
        } else if (root.right == null) {
            List<List<Integer>> subResL = pathSum_Recursion(root.left, targetSum - root.val);
            for( List<Integer> l : subResL) {
                if(l.size() > 0) l.add(0, root.val);
            }
            return subResL;
        } else {
            List<List<Integer>> subResR = pathSum_Recursion(root.right, targetSum - root.val);
            List<List<Integer>> subResL = pathSum_Recursion(root.left, targetSum - root.val);
            for( List<Integer> l : subResL) {
                //System.out.println(l.toString());
                if(l.size() > 0) l.add(0, root.val);
            }
            for( List<Integer> l : subResR) {
                if(l.size() > 0) l.add(0, root.val);
            }
            List<List<Integer>> res = new ArrayList<>();
            res.addAll(subResR);
            res.addAll(subResL);
            return res;
        }
    }

    private void recurseTree(TreeNode root, int sum, List<Integer> pathNodes, List<List<Integer>> pathsList){
        if(root == null) return;

        pathNodes.add(root.val);
        if(root.val == sum && root.left == null && root.right == null) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {
            recurseTree(root.left ,sum - root.val, pathNodes, pathsList);
            recurseTree(root.right ,sum - root.val, pathNodes, pathsList);
        }
        pathNodes.remove(pathNodes.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;        
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
        String[] vals = new String[]{"5","4","8","11","null","13","4","7","2","null","null","5","1"};
        TreeNode root = s.constructTree(vals);
        List<List<Integer>> ress = s.pathSum_Recursion(root, 22);
        for (List<Integer> res: ress){
            System.out.println(res.toString());
        }
    }
}