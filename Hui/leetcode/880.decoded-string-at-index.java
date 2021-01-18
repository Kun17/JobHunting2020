/*
 * @lc app=leetcode id=880 lang=java
 *
 * [880] Decoded String at Index
 */

// @lc code=start
class Solution {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        for(int i = 0; i < S.length(); i++) {
            if ('2' <= S.charAt(i) && S.charAt(i) <= '9') {
                len *= (S.charAt(i) - '0');
            } else {
                len++;
            }
        }
        for(int i = S.length() - 1; i >= 0; i--) {
            K %= len;
            if('2' <= S.charAt(i) && S.charAt(i) <= '9') {
                len /= (S.charAt(i) - '0');
            } else {
                if (K == 0) {
                    return String.valueOf(S.charAt(i));
                } else {
                    len--;
                }
            }
        }

        return "";
    }
}
// @lc code=end

