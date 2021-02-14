/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else if (c == 0) {
                    if(r == 0) {
                        dp[c] = 1;
                    }
                } else {
                    dp[c] = dp[c] + dp[c - 1];
                }
            }
        }

        return dp[n - 1];
     }
}
// @lc code=end

