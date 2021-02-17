/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (e - s > 1) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < nums[e]) {
                e = mid;
            } else {
                s = mid;
            }
        }

        return Math.min(nums[s], nums[e]);
    }
}
// @lc code=end

