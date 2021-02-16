/*
 * @lc app=leetcode id=1523 lang=java
 *
 * [1523] Count Odd Numbers in an Interval Range
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        int ret = (high - low) / 2;
        if(high % 2 == 1 || low % 2 == 1) {
            ret++;
        }

        return ret;
    }
}
// @lc code=end

