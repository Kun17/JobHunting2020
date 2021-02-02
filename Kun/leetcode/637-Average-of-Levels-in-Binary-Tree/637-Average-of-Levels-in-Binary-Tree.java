import java.util.List;
import java.util.LinkedList;
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
    // I know how to do it using traversal
    // Let's try with recursion this time
    List<List<TreeNode>> levels = new LinkedList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        // To add the sum of everyLevel by BFS, here we use recursion
        getLevelSum(root, 0);
        List<Double> res = new LinkedList<Double>();
        for(List<TreeNode> levelStorage: levels){
            long sum = 0;
            for(TreeNode node: levelStorage){
                sum += node.val;
            }
            res.add((double)sum/levelStorage.size());
        }
        return res;
    }

    void getLevelSum(TreeNode root, int level){
        List<TreeNode> levelStorage;
        if(root == null) return;
        if(levels.size() == level){
            levelStorage = new LinkedList<TreeNode>();
            levels.add(levelStorage);
        }
        levels.get(level).add(root);
        getLevelSum(root.left, level+1);
        getLevelSum(root.right, level+1);
    }
}
