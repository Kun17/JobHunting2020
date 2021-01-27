import java.util.Queue;
import java.util.ArrayDeque;

// I use this to implement priority queue
class maxBinaryHeap_node{
    
    class Node {
        int val;
        Node parent, left, right;
        Node(int val) {this.val = val;}
        Node(int val, Node parent) {this.val = val;this.parent = parent;}
    }

    Node Root;

    Node insert(int v){
        Node root = Root;
        if (root == null) {
            Root = new Node(v);
            return Root;
        }
        // Do a BFS using queue
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);
        while(!Q.isEmpty()){
            Node curNode = Q.poll();
            // if v is less than the node
            if(v <= curNode.val) {
                if (curNode.left == null) {
                    curNode.left = new Node(v, curNode);
                    break;
                }
                if (curNode.right == null) {
                    curNode.right = new Node(v, curNode);
                    break;
                }
            } else {
                int temp = curNode.val;
                curNode.val = v;
                v = temp;
                Q.add(curNode);
            }
            if (curNode.left != null) Q.add(curNode.left);
            if (curNode.right != null) Q.add(curNode.right);
        }
        Root = root;
        return root;
    }

    Node getMax(){
        return Root;
    }

    Node extractMax(){
        // First, find the right most leaf
        if (Root == null) return null;
        Node curRoot = new Node(Root.val);
        Root.val = findNRemoveTheLastLeaf().val;
        maxHeapify(Root);
        return curRoot;
    }

    Node maxHeapify(Node root){
        // Using BFS to swap the root to its right place
        if (Root == null) return null;
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);
        while(!Q.isEmpty()){
            Node curNode = Q.poll();
            if((curNode.left != null && curNode.val < curNode.left.val) && (curNode.right == null || (curNode.right != null && curNode.right.val < curNode.left.val))){
                int temp = curNode.left.val;
                curNode.left.val = curNode.val;
                curNode.val = temp;
                Q.add(curNode.left);
            } else if ((curNode.right != null && curNode.val < curNode.right.val) && (curNode.left == null || (curNode.left != null && curNode.left.val < curNode.right.val))){
                int temp = curNode.right.val;
                curNode.right.val = curNode.val;
                curNode.val = temp;
                Q.add(curNode.right);
            }
        }
        Root = root;
        return Root;
    }

    Node findNRemoveTheLastLeaf(){
        Node lastLeaf = Root;
        // Do a BFS using queue, find the last leaf
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(Root);
        while(!Q.isEmpty()){
            Node curNode = Q.poll();
            if (curNode.left != null) Q.add(curNode.left);
            if (curNode.right != null) Q.add(curNode.right);
            if(Q.isEmpty()) {
                lastLeaf = curNode;
                if (lastLeaf.parent != null) {
                    if (lastLeaf.parent.left == lastLeaf) lastLeaf.parent.left = null;
                    else lastLeaf.parent.right = null;
                } else {Root = null;}
            }
        }
        return lastLeaf;
    }
    
    Node remove(int key){
        Node target = null;
        // Do a BFS using queue
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(Root);
        while(!Q.isEmpty()){
            Node curNode = Q.poll();
            if (curNode.val == key){
                target = curNode;
                break;
            }
            if (curNode.left != null) Q.add(curNode.left);
            if (curNode.right != null) Q.add(curNode.right);
        }
        if (target == null) return null;
        target.val = findNRemoveTheLastLeaf().val;
        maxHeapify(target);
        return Root;
    }

    // public static void main(String[] Args){
    //     maxBinaryHeap_node h = new maxBinaryHeap_node();
    //     h.Root = h.insert(1);
    //     h.insert(2);
    //     h.insert(3);
    //     h.insert(4);
    //     h.insert(5);
    //     h.remove(5);
    //     System.out.println(h.Root.val);
    //     while(h.Root != null){
    //         System.out.println(h.extractMax().val);
    //     }
    // }
}