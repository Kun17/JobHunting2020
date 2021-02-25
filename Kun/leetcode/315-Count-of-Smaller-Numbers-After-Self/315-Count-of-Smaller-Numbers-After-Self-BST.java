import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class Solution2 {
    class node{
        int val;
        int count;
        node left, right;
        node(int val){
            this.val = val;
            this.count = 1;
        }
    }
    node root = null;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        List<node> sequence = new ArrayList<>();
        for(int i = len-1; i >= 0; i--){
            node cur = new node(nums[i]);
            sequence.add(cur);
            res.add(insert(root, cur));
        }
        Collections.reverse(res);
        return res;
    }

    int insert(node root, node cur){
        int thisCount = 0;
        if(this.root == null){
            this.root = cur;
        } else {
            while(true){
                if(cur.val <= root.val){
                    root.count++;
                    if(root.left == null) {root.left = cur;break;}
                    else root = root.left;
                } else {
                    thisCount += root.count;
                    if(root.right == null) {root.right = cur;break;}
                    else root = root.right;
                }
            }
        }
        return thisCount;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int[] nums = new int[]{5,2,6,1};
        System.out.println(s.countSmaller(nums));
    }
}