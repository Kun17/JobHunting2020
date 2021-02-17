/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) sign = -1;

        long ret = 0;
        x = Math.abs(x);
        while (x > 0) {
            int digit = x % 10;
            x /= 10;

            ret *= 10;
            ret += digit;
            if (ret > Integer.MAX_VALUE) return 0;
        }

        return sign * (int) ret;
    }
}
// @lc code=end

