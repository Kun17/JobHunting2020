/*
 * @lc app=leetcode id=712 lang=java
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */

// @lc code=start
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] dp = new int[n2 + 1];
        for (int j = 0; j < n2; j++) {
            dp[j + 1] = dp[j] + (int) s2.charAt(j);
        }

        for (int i = 1; i <= n1; i++) {
            int[] nextDP = new int[n2 + 1];
            nextDP[0] = dp[0] + s1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    nextDP[j] = dp[j - 1];
                } else {
                    // nextDP[j] = dp[j - 1] + (int) s1.charAt(i - 1) + (int) s2.charAt(j - 1);
                    nextDP[j] = Math.min( nextDP[j - 1] + (int) s2.charAt(j - 1), dp[j] + (int) s1.charAt(i - 1));
                    // nextDP[j] = Math.min(nextDP[j], nextDP[j - 1] + (int) s2.charAt(j - 1));
                }
                // nextDP[j] = Math.min(nextDP[j], dp[j] + (int) s1.charAt(i - 1));
                // nextDP[j] = Math.min(nextDP[j], nextDP[j - 1] + (int) s2.charAt(j - 1));
            }
            dp = nextDP;
        }

        return dp[n2];
    }
}
// @lc code=end

