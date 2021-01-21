/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        long s = 0L, e = 0L;
        for(int num : nums) {
            e += num;
            s = Math.max(s, num);
        }
        // System.out.println(s);
        // System.out.println(e);
        while(s < e) {
            long mid = s + (e - s) / 2;
            long sum = 0;
            int cnt = 1;
            for(int num : nums) {
                if(sum + num > mid) {
                    sum = num;
                    cnt++;
                } else {
                    sum += num;
                }
            }
            
            if(cnt <= m) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return (int) s;

        // int[][] dp = new int[nums.length + 1][m + 1];
        // int[] sum = new int[nums.length + 1];
        // for(int i = 1; i <= nums.length; i++) {
        //     sum[i] = sum[i - 1] + nums[i - 1];
        //     dp[i][0] = Integer.MAX_VALUE;
        // }
        // for(int j = 1; j <= m; j++) {
        //     for(int i = 1; i <= nums.length; i++) {
        //         if(i < j) {
        //             continue;
        //         }
        //         dp[i][j] = Integer.MAX_VALUE;
        //         for(int k = 0; k < i; k++) {
        //             if(k + 1 < j) continue;
        //             dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
        //         }
        //     }
        // }
        // return dp[nums.length][m];
    }
}
// @lc code=end

