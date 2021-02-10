/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int min = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                } else {
                    min = Math.min(min, dp[i - 1][j - 1] + 1);
                }
                dp[i][j] = min;
            }
        }

        return dp[n][m];
    }
}
// @lc code=end

