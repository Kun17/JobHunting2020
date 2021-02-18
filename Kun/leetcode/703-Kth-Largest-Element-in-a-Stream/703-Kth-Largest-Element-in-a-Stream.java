// import java.util.List;
// import java.util.ArrayList;
// import java.util.Arrays;

// class KthLargest {

//     List<Integer> arr;
//     int[] nums;
//     int k;
//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         Arrays.sort(nums);
//         this.nums = nums;
//         arr = new ArrayList<>();
//         for(int num: nums){
//             arr.add(num);
//         }
//     }
    
//     public int add(int val) {
//         int pos = Arrays.binarySearch(nums, val);
//         if(pos < 0) pos = - pos - 1;
//         arr.add(pos, val);
//         nums = arr.stream().mapToInt(i -> i).toArray();
//         return nums[nums.length - k];
//     }

//     public static void main(String[] Args){
//         int[] nums = new int[]{4,5,8,2};
//         KthLargest s = new KthLargest(3, nums);
//         System.out.println(s.add(3));
//         System.out.println(s.add(5));
//     }
// }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */