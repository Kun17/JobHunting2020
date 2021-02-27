import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // We can use priority queue to solve this problem
        // which would take nlogn time and n space
        PriorityQueue<Integer> PQ = new PriorityQueue<>(k, (x,y) -> (y-x));
        int len = nums.length;
        int[] res = new int[len-k+1];
        for(int i = 0, j=0; i < len; i++){
            PQ.add(nums[i]);
            if(PQ.size() == k){
                res[j] = PQ.peek();
                PQ.remove(nums[j]);
                j++;
            }
        }
        return res;
    }
}