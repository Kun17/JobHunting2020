import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    // [1,3,-1,-3,5,3,6,7]
    // 
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len-k+1];
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) dq.removeLast();
            dq.addLast(nums[i]);
        }
        res[0] = dq.peekFirst();
        for(int i = k, j=0; i < len; i++){
            if(!dq.isEmpty() && dq.peekFirst() == nums[j]) dq.removeFirst();
            while(!dq.isEmpty() && dq.peekLast() < nums[i]) dq.removeLast();
            dq.addLast(nums[i]);
            res[++j] = dq.peekFirst();
        }
        return res;
    }
}