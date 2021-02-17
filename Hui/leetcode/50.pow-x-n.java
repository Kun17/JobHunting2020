/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long nlong = (long) n;
        if (nlong < 0) {
            nlong = -nlong;
            x = 1 / x;
        }

        if (nlong % 2 == 0) {
            return myPow(x * x, (int) (nlong / 2));
        }
        return x * myPow(x * x, (int) (nlong / 2));
    }
}
// @lc code=end

