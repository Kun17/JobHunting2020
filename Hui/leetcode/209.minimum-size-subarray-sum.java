/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if(sum[nums.length] < s) return 0;
        
        int ret = Integer.MAX_VALUE;
        for(int i = 1; i <= nums.length; i++) {
            int start = 0, end = i - 1;
            while(end - start > 1) {
                int mid = start + (end - start) / 2;
                if(sum[mid] + s < sum[i]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if(sum[i] - sum[end] >= s) {
                ret = Math.min(ret, i - end);
            } else if(sum[i] - sum[start] >= s) {
                ret = Math.min(ret, i - start);
            }
        }

        return ret;
    }
}
// @lc code=end

