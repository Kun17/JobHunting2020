import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1;
            int subTarget = target - nums[i];
            while(l < r){
                int gap = subTarget - nums[l] - nums[r];
                if(Math.abs(gap) < min) {res = nums[i] + nums[l] + nums[r];min = Math.abs(gap);}
                if(gap < 0){
                    r--;
                } else if(gap > 0){
                    l++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{1,1,1,0};
        System.out.println(s.threeSumClosest(nums, -100));
    }
}