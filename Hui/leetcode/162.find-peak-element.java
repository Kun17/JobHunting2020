/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int s = 0, e = nums.length - 1;
        while(e - s > 1) {
            int mid = s + (e - s) / 2;
            if(nums[mid - 1] < nums[mid]) {
                s = mid;
            } else {
                e = mid;
            }
        }

        if(nums[s] > nums[e]) {
            return s;
        }

        return e;
    }
}
// @lc code=end

