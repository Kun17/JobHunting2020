/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        memo[s.length()] = 1;
        return helper(s, 0);
    }

    public int helper(String s, int pos) {
        if (memo[pos] != -1) {
            return memo[pos];
        }

        if (s.charAt(pos) == '0') {
            return 0;
        }

        int ret = helper(s, pos + 1);

        if (valid(s, pos, pos + 2)) {
            ret += helper(s, pos + 2);
        }
        memo[pos] = ret;

        return memo[pos];
    }

    public boolean valid(String s, int si, int ei) {
        if (ei == s.length() + 1) {
            return false;
        }
        
        int d1 = (int) (s.charAt(si) - '0');
        int d2 = (int) (s.charAt(si + 1) - '0');
        if (d1 * 10 + d2 <= 0 || d1 * 10 + d2 > 26) {
            return false;
        }
        return true;
    }
}
// @lc code=end

