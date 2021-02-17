/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            cnt++;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
// @lc code=end

