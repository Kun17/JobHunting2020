import java.util.PriorityQueue;

class test{

    PriorityQueue<Integer> PQ;
    public test(int[] nums){
        PQ = new PriorityQueue<>();
        for(int num: nums){
            PQ.offer(num);
        }
    }

    public static void main(String[] Args){
        int[] nums = new int[]{4,5,8,2};
        test s = new test(nums);
        while(!s.PQ.isEmpty()){
            System.out.println(s.PQ.poll());
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */