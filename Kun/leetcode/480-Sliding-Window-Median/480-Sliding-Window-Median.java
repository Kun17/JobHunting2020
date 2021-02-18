import java.util.PriorityQueue;

class Solution {
    PriorityQueue<Integer> hi;
    PriorityQueue<Integer> lo;
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return new double[]{};
        hi = new PriorityQueue<>();
        lo = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        double[] res =  new double[len - k + 1];
        // lo's size is at most 1 bigger than the hi heap
        for(int i = 0; i < k; i++){
            addNum(nums[i]);
        }

        for(int i = k; i < len; i++){
            if(k % 2 == 0) res[i-k] = lo.peek()/2.0 + hi.peek()/2.0;
            else res[i-k] = lo.peek();
            if(nums[i-k] <= res[i-k]) {
                lo.remove(nums[i-k]);
            } else {
                hi.remove(nums[i-k]);
            }
            addNum(nums[i]);
        }
        if(k % 2 == 0) {
            res[len-k] = lo.peek()/2.0 + hi.peek()/2.0;
        }
        else res[len-k] = lo.peek();

        return res;
    }

    private void addNum(int num){
        lo.offer(num);
        hi.offer(lo.poll());
        while(hi.size() > lo.size()){
            lo.offer(hi.poll());
        }
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{2147483647,1,2,3,4,5,6,7,2147483647};
        double[] ress = s.medianSlidingWindow(nums, 2);
        for(double res: ress){
            if(res < 0) System.out.println("haha");
            System.out.println(res);
        }
    }
}