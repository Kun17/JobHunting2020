import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    private static final String spliter = ",";
    private static final String na = "x";

    //Let's go with DFS 1st, then BFS
    // Encodes a tree to a single string.
    public String serialize_DFS(TreeNode root) {
        if(root == null) return "null";
        Deque<TreeNode> stack = new ArrayDeque<>();
        String res = "";

        stack.push(root);
        res += String.valueOf(root.val) + ",";
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if (curNode.left != null) {
                res += String.valueOf(curNode.left.val) + ",";
                stack.push(curNode.left);
            } else res += "null,";
            if (curNode.right != null) {
                res += String.valueOf(curNode.right.val) + ",";
                stack.push(curNode.right);
            } else res += "null,";
        }
        return res.substring(0, res.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_DFS(String data) {
        if (data == "null") return null;
        String[] dArr = data.split(",");
        int N = dArr.length;

        Deque<TreeNode> stack = new ArrayDeque<>();
        int idx = 0;
        TreeNode root = new TreeNode(Integer.valueOf(dArr[idx++]));
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curNode = stack.poll();
            if (idx < N && !dArr[idx].equals("null")) {
                TreeNode l = new TreeNode(Integer.valueOf(dArr[idx]));
                curNode.left = l;
                stack.push(l);
            }
            idx++;
            if (idx < N && !dArr[idx].equals("null")) {
                TreeNode r = new TreeNode(Integer.valueOf(dArr[idx]));
                curNode.right = r;
                stack.push(r);
            }
            idx++;
        }
        return root;
    }

    public String serialize_BFS(TreeNode root) {
        if (root == null) return "null";
        String res = "";

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        res += String.valueOf(root.val) + ",";
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (curNode.left != null){
                queue.add(curNode.left);
                res += String.valueOf(curNode.left.val) + ",";
            } else res += "null,";
            if (curNode.right != null){
                queue.add(curNode.right);
                res += String.valueOf(curNode.right.val) + ",";
            } else res += "null,";
        }

        return res.substring(0, res.length()-1);
    }

    public TreeNode deserialize_BFS(String data) {
        if (data == "null") return null;
        String[] dArr = data.split(",");
        int N = dArr.length;

        Queue<TreeNode> queue = new ArrayDeque<>();
        int idx = 0;
        TreeNode root = new TreeNode(Integer.valueOf(dArr[idx++]));
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (idx < N && !dArr[idx].equals("null")) {
                TreeNode l = new TreeNode(Integer.valueOf(dArr[idx]));
                curNode.left = l;
                queue.add(l);
            }
            idx++;
            if (idx < N && !dArr[idx].equals("null")) {
                TreeNode r = new TreeNode(Integer.valueOf(dArr[idx]));
                curNode.right = r;
                queue.add(r);
            }
            idx++;
        }
        return root;
    }

    public String serialize_PreOdDFS_Recursion(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) sb.append(na).append(spliter);
        else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_PreOdDFS_Recursion(String data) {
        String[] dArr = data.split(spliter);
        List<String> dList = Arrays.asList(dArr);
        Queue<String> q = new ArrayDeque<>();
        q.addAll(dList);
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q){
        String curNodeVal = q.poll();
        if(curNodeVal.equals(na)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(curNodeVal));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
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
        Codec c = new Codec();
        String[] vals = new String[]{"1","2","3","null","null","4","5"};
        TreeNode root = c.constructTree(vals);
        String data = c.serialize_PreOdDFS_Recursion(root);
        System.out.println(data);
        TreeNode dRoot = c.deserialize_PreOdDFS_Recursion(data);
        System.out.println(dRoot.val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));