/*
 * @lc app=leetcode id=1531 lang=java
 *
 * [1531] String Compression II
 */

// @lc code=start
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // remove current char
                if (j > 0) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // keep current char
                // delete along scanning back
                // try to group as many as current char
                int cnt = 0, remove = 0;
                for (int m = i; m > 0; m--) {
                    if (s.charAt(m - 1) == s.charAt(i - 1)) {
                        cnt++;
                    } else {
                        remove++;
                    }
                    if (remove > j) break;
                    dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - remove] + calcLen(cnt));
                }

            }
        }

        return dp[n][k];
    }

    public int calcLen(int cnt) {
        if (cnt == 0) return 0;
        else if (cnt == 1) return 1;
        else if (cnt < 10) return 2;
        else if (cnt < 100) return 3;
        return 4;
    }


    /*
    int min;
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] chs = s.toCharArray();
        min = s.length();
        helper(chs, k, 0);
        return min;
    }

    public void helper(char[] chs, int k, int pos) {
        if (pos == chs.length && k == 0) {
            min = Math.min(min, getLength(chs));
        }

        if (pos == chs.length || k < 0) {
            return;
        }

        char c = chs[pos];
        chs[pos] = '-';
        helper(chs, k - 1, pos + 1);
        chs[pos] = c;

        helper(chs, k, pos + 1);
    }

    public int getLength(char[] chs) {
        // System.out.println(new String(chs));
        int count = 0;
        char cur = '#';
        int len = 0;
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == '-') continue;
            if (c != cur) {
                len++;
                if (1 < count && count < 10) {
                    len++;
                } else if (10 <= count && count < 100) {
                    len += 2;
                }
                cur = c;
                count = 1;
            } else {
                count++;
            }
        }

        if (cur == '#') return 0;
        len++;
        if (1 < count && count < 10) {
            len += 1;
        } else if (10 <= count && count < 100) {
            len += 2;
        }

        return len - 1;
    }
    */
}
// @lc code=end

