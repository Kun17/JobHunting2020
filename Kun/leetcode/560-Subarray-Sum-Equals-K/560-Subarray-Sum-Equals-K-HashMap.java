import java.util.Map;
import java.util.HashMap;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int cumulativeSum = 0;
        int count = 0;
        map.put(0, 1);
        for(int i = 0; i < len; i++){
            cumulativeSum += nums[i];
            if(map.containsKey(cumulativeSum - k)) count += map.get(cumulativeSum - k);
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        int nums[] = new int[]{1,1,1,1,1};
        System.out.println(s.subarraySum(nums, 1));
    }
}