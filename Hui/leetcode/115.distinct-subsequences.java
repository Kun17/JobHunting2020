/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(s, t, 0, 0);
    }

    public int helper(String s, String t, int si, int ti) {
        if (ti == t.length()) {
            return 1;
        }
        if (si == s.length()) {
            return 0;
        }

        if (memo[si][ti] != -1) {
            return memo[si][ti];
        }
        int count = 0;
        char tc = t.charAt(ti);
        for (int i = si; i < s.length(); i++) {
            // if (s.length() - i < t.length() - ti) {
            //     break;
            // }
            if (s.charAt(i) == tc) {
                count += helper(s, t, i + 1, ti + 1);
            }
        }

        memo[si][ti] = count;
        return count;
    }
}
// @lc code=end

