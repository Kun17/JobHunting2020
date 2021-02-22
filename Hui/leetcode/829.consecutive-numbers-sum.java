/*
 * @lc app=leetcode id=829 lang=java
 *
 * [829] Consecutive Numbers Sum
 */

// @lc code=start
class Solution {
    public int consecutiveNumbersSum(int N) {
        boolean[][] dp = new boolean[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][i] = true;
        }
        for (int n = 1; n <= N; n++) {
            for (int end = 1; end < n; end++) {
                if (dp[n - end][end - 1])
                    dp[n][end] = true;
            }
        }

        int ret = 0;
        for (int end = 1; end <= N; end++) {
            if (dp[N][end]) {
                ret++;
            }
        }

        return ret;
    }
}
// @lc code=end

