/*
 * @lc app=leetcode id=629 lang=java
 *
 * [629] K Inverse Pairs Array
 */

// @lc code=start
class Solution {
    public int kInversePairs(int n, int k) {
        int M = 1000000007;
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= k; j++) {
                for(int m = 0; m <= Math.min(j, i - 1); m++) {
                    dp[i][j] = dp[i][j] + dp[i-1][j - m];
                }
                dp[i][j] %= M;
            }
        }

        return (int) dp[n][k];
    }
}
// @lc code=end

