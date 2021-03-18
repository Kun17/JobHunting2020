/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (e - s > 1) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == nums[e]) {
                e--;
            } else if (nums[mid] < nums[e]) {
                e = mid;
            } else {
                s = mid;
            }
        }
        // System.out.println(s + " " + e);
        
        return Math.min(nums[s], nums[e]);
    }
}
// @lc code=end

