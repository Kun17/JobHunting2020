/*
 * @lc app=leetcode id=1411 lang=java
 *
 * [1411] Number of Ways to Paint N × 3 Grid
 */

// @lc code=start
class Solution {
    long MOD = 1000000007;
    public int numOfWays(int n) {
        long a121 = 6, a123 = 6;

        for (int i = 1; i < n; i++) {
            long b121 = (a121 * 3 + a123 * 2) % MOD;
            long b123 = (a121 * 2 + a123 * 2) % MOD;
            a121 = b121;
            a123 = b123;
        }

        return (int) ((a121 + a123) % MOD);
    }
}
// @lc code=end

