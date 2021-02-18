import java.util.PriorityQueue;

class KthLargest2 {

    PriorityQueue<Integer> Q;
    int k;
    public KthLargest2(int k, int[] nums) {
        this.k = k;
        this.Q = new PriorityQueue<>(k);
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(Q.size() < k) {
            Q.offer(val);
        } else if(Q.peek() < val){
            Q.poll();
            Q.offer(val);
        }
        return Q.peek();
    }

    public static void main(String[] Args){
        int[] nums = new int[]{4,5,8,2};
        KthLargest2 s = new KthLargest2(3, nums);
        System.out.println(s.add(3));
        System.out.println(s.add(5));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */