/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        int cur = 0;
        while (cur < s1.length() && s1.charAt(cur) == s3.charAt(cur)) {
            dp[cur + 1][0] = true;
            cur++;
        }

        cur = 0;
        while (cur < s2.length() && s2.charAt(cur) == s3.charAt(cur)) {
            dp[0][cur + 1] = true;
            cur++;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                if (c1 == c3) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (c2 == c3) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()];

    }
}
// @lc code=end

