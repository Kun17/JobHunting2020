/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        int[] ret = new int[n + 1];
        ret[1] = 1;
        for(int i = 2; i <= n; i++) {
            int num2 = ret[p2] * 2;
            int num3 = ret[p3] * 3;
            int num5 = ret[p5] * 5;

            ret[i] = Math.min(num2, Math.min(num3, num5));
            if(num2 == ret[i]) {
                p2++;
            }
            if(num3 == ret[i]) {
                p3++;
            }
            if(num5 == ret[i]) {
                p5++;
            }
        }
        return ret[n];
    }
}
// @lc code=end

