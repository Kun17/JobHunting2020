/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[] dp = new int[B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            int[] next = new int[B.length + 1];
            for (int j = 1; j <= B.length; j++) {
                next[j] = Math.max(dp[j], next[j - 1]);
                if (A[i - 1] == B[j - 1]) {
                    next[j] = Math.max(next[j], dp[j - 1] + 1);
                }
            }
            dp = next;
        }

        return dp[B.length];
    }
}
// @lc code=end

