/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num: nums) {
            sum += num;
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }

        return max;
    }
}
// @lc code=end

