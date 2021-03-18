/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int d = 2; d < n + 2; d++) {
            for (int i = 0; i + d < n + 2; i++) {
                int j = i + d;
                for (int k = i + 1; k < j; k++) {
                    int left = 1;
                    if (i > 0) {
                        left = nums[i - 1];
                    }
                    int right = 1;
                    if (j < n + 1) {
                        right = nums[j - 1];
                    }
                    dp[i][j] = Math.max(dp[i][j], left * nums[k - 1] * right + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
// @lc code=end

