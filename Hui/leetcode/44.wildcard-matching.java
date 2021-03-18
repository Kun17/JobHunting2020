/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        
        int[][] memo = new int[s.length()][p.length()];

        return compare(s, p, 0, 0, memo) == 1;
    }

    public int compare(String s, String p, int i, int j, int[][] memo) {
        if (i == s.length() && j == p.length()) return 1;
        if (j == p.length()) return -1;
        if (i == s.length()) {
            if (p.charAt(j) == '*') {
                return compare(s, p, i, j + 1, memo);
            }
            return -1;
        }

        if (memo[i][j] != 0) return memo[i][j];

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            memo[i][j] = compare(s, p, i + 1, j + 1, memo);
        } else if (p.charAt(j) == '*') {
            if (compare(s, p, i + 1, j, memo) == 1 || compare(s, p, i, j + 1, memo) == 1 || compare(s, p, i + 1, j + 1, memo) == 1) {
                memo[i][j] = 1;
            } else {
                memo[i][j] = -1;
            }
        } else {
            memo[i][j] = -1;
        }

        return memo[i][j];
    }
}
// """\n"***""
// @lc code=end

