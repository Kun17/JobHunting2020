/*
 * @lc app=leetcode id=1335 lang=java
 *
 * [1335] Minimum Difficulty of a Job Schedule
 */

// @lc code=start
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] dp = new int[n + 1][d + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= d; j++) {
                if (j > i) break;
                if (j == 1) {
                    dp[i][j] = Math.max(dp[i - 1][1], jobDifficulty[i - 1]);
                } else {
                    int max = Integer.MIN_VALUE;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k > j - 1; k--) {
                        max = Math.max(max, jobDifficulty[k - 1]);
                        int cur = dp[k - 1][j - 1] + max;
                        dp[i][j] = Math.min(dp[i][j], cur);
                    }
                }
            }
        }

        return dp[n][d];
    }
}
// @lc code=end

