/*
 * @lc app=leetcode id=440 lang=java
 *
 * [440] K-th Smallest in Lexicographical Order
 */

// @lc code=start
class Solution {
    int k;
    int ret;
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int step = getStep(n, (long) cur, (long) cur + 1);
            if (step <= k) {
                cur = cur + 1;
                k -= step;
            } else {
                cur = cur * 10;
                k--;
            }
        }
        return cur;
    }

    public int getStep(int n, long cur1, long cur2) {
        int ret = 0;
        while (cur1 <= n) {
            ret += Math.min(n + 1, cur2) - cur1;
            cur1 *= 10;
            cur2 *= 10;
        }

        return ret;
    }
    //681692778\n351251360
}
// @lc code=end

