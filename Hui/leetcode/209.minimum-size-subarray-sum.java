/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        int l = -1, r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (l < r && sum >= s) {
                len = Math.min(len, r - l);
                l++;
                sum -= nums[l];
            }
            r++;
        }

        if (len == Integer.MAX_VALUE) return 0;
        return len;
        // int[] sum = new int[nums.length + 1];
        // for(int i = 1; i <= nums.length; i++) {
        //     sum[i] = sum[i - 1] + nums[i - 1];
        // }
        // if(sum[nums.length] < s) return 0;
        
        // int ret = Integer.MAX_VALUE;
        // for(int i = 1; i <= nums.length; i++) {
        //     int start = 0, end = i - 1;
        //     while(end - start > 1) {
        //         int mid = start + (end - start) / 2;
        //         if(sum[mid] + s < sum[i]) {
        //             start = mid;
        //         } else {
        //             end = mid;
        //         }
        //     }
        //     if(sum[i] - sum[end] >= s) {
        //         ret = Math.min(ret, i - end);
        //     } else if(sum[i] - sum[start] >= s) {
        //         ret = Math.min(ret, i - start);
        //     }
        // }

        // return ret;
    }
}
// @lc code=end

