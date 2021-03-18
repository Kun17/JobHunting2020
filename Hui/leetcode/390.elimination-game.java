/*
 * @lc app=leetcode id=390 lang=java
 *
 * [390] Elimination Game
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        return fl(n);
    }

    public int fl(int n) {
        if (n == 1) return 1;
        return fr(n / 2) * 2;
    }

    public int fr(int n) {
        if (n == 1) return 1;
        if (n % 2 == 1) {
            return fl(n / 2) * 2;
        }
        return fl(n / 2) * 2 - 1;
    }
}
// @lc code=end