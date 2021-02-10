/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int cur = 1;
        int rl = 0, rh = n - 1;
        int cl = 0, ch = n - 1;
        while (rl <= rh && cl <= ch) {
            for (int c = cl; c <= ch; c++) {
                ret[rl][c] = cur++;
            }
            rl++;
            for (int r = rl; r <= rh; r ++) {
                ret[r][ch] = cur++;
            }
            ch--;
            for (int c = ch; c >= cl; c--) {
                ret[rh][c] = cur++;
            }
            rh--;
            for (int r = rh; r >= rl; r--) {
                ret[r][cl] = cur++;
            }
            cl++;
        }

        return ret;
    }
}
// @lc code=end

