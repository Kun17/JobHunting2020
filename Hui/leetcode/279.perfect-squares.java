/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            int cur = 1;
            while(cur * cur <= i) {
                dp[i] = Math.min(dp[i], dp[i - cur * cur] + 1);
                cur++;
            }
            // System.out.println(i + " = " + dp[i]);
        }

        return dp[n];
    }
}
// @lc code=end

