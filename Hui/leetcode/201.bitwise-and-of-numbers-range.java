/*
 * @lc app=leetcode id=201 lang=java
 *
 * [201] Bitwise AND of Numbers Range
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m = m >>> 1;
            n = n >>> 1;
            shift++;
        }

        return m << shift;
    }
}
// @lc code=end

