/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        return helper(n, n, dp);
    }

    public int helper(int target, int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != 0) {
            return dp[n];
        }

        int max = 0;
        if (n != target) {
            max = n;
        }
        for (int i = n - 1; i >= 1; i--) {
            max = Math.max(max, i * helper(target, n - i, dp));
        }
        dp[n] = max;
        return dp[n];
    }
}
// @lc code=end

