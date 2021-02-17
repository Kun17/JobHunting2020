/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int offset = 1;
        for (int n = 1; n <= num; n++) {
            if (offset * 2 == n) {
                offset *= 2;
            }
            dp[n] = dp[n - offset] + 1;
        }

        return dp;
    }
}
// @lc code=end

