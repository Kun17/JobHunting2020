/*
 * @lc app=leetcode id=1732 lang=java
 *
 * [1732] Find the Highest Altitude
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int max = 0;
        for(int g : gain) {
            altitude += g;
            max = Math.max(max, altitude);
        }
        return max;
    }
}
// @lc code=end

