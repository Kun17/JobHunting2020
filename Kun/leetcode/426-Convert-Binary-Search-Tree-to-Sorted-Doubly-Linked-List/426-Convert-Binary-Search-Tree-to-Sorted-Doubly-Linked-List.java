import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public Node treeToDoublyList(Node root) {
        // As we traverse through the tree inorderly, we make its child's right point to its parent
        // So we can trace back
        Stack<Node> stack = new Stack<>();
        Node preCur = root;
        while(preCur.left != null){
            stack.push(preCur);
            preCur = preCur.left;
        }
        Node smallest = preCur;
        stack.push(smallest);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            if(cur.right == null){
                if(stack.isEmpty()) {
                    cur.right = smallest;
                    smallest.left = cur;
                } else {
                    cur.right = stack.peek();
                    stack.peek().left = cur;   
                }
            } else {
                Node next = cur.right;
                stack.push(next);
                while(next.left != null){
                    next = next.left;
                    stack.push(next);
                }
                next.left = cur;
            }
        }
        return smallest;
    }

    Node constructTree(String[] vals){
        if(vals.length == 0) return null;
        int idx = 0;
        Node root = new Node(Integer.valueOf(vals[idx++]));
        Queue<Node> queue = new ArrayDeque<>();
        int N = vals.length;

        queue.add(root);
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if (idx < N && vals[idx] != "null") {
                Node l = new Node(Integer.valueOf(vals[idx]));
                curNode.left = l;
                queue.add(l);
            }
            idx++;
            if (idx < N && vals[idx] != "null") {
                Node r = new Node(Integer.valueOf(vals[idx]));
                curNode.right = r;
                queue.add(r);
            }
            idx++;
        }
        return root;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        String[] input = new String[]{"4","2","5","1","3"};
        Node root = s.constructTree(input);
        Node cur = s.treeToDoublyList(root);
        for(int i = 0; i <= input.length; i++){
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
        for(int i = 0; i <= input.length; i++){
            System.out.print(cur.val + " ");
            cur = cur.left;
        }
        System.out.println();
    }
}