/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num: nums) {
            ret = ret & num;
        }

        return ret;
    }
}
// @lc code=end

