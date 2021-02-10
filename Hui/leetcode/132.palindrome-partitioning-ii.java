/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    int[][] memo;
    public int minCut(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            isPal[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    isPal[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1]) {
                    isPal[i][j] = true;
                }
            }
        }

        memo = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return minCut(isPal, 0, s.length() - 1);
    }

    public int minCut(boolean[][] isPal, int s, int e) {
        if (memo[s][e] != - 1) {
            return memo[s][e];
        }

        if (isPal[s][e]) {
            memo[s][e] = 0;
            return memo[s][e];
        }

        int min = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            if (!isPal[s][i]) continue;
            int cut = minCut(isPal, i + 1, e) + 1;
            min = Math.min(min, cut);
        }

        memo[s][e] = min;
        // System.out.println(s + " " + e);
        // System.out.println(min);
        return memo[s][e];
    }
}
// @lc code=end

