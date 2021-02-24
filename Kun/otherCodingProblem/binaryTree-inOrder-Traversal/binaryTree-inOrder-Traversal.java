import java.util.Stack;

class Iterator{
    Stack<TreeNode> stack;
    Iterator(TreeNode root){
        this.stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public TreeNode next(){
        TreeNode curNode = stack.pop();
        if(curNode.right != null){
            TreeNode next = curNode.right;
            while(next != null){
                stack.push(next);
                next = next.left;
            }
        }
        return curNode;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public static void main(String[] Args){
        String[] vals = new String[]{"3","9","20","null","null","15","7"};
        Constructor c = new Constructor();
        TreeNode root = c.constructTree(vals);
        Iterator it = new Iterator(root);
        while(it.hasNext()){
            System.out.println(it.next().val);
        }
    }
}