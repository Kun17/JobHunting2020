/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, cur = 0;
        int ret = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                ret = i + 1;
                cur = 0;
            }
        }
        if (total >= 0) {
            return ret;
        }
        return -1;
    }
}
// @lc code=end

