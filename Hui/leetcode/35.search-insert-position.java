/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while(e - s > 1) {
            int mid = s + (e - s) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                s = mid;
            } else {
                e = mid;
            }
        }

        if(nums[s] == target) {
            return s;
        } else if(nums[e] == target) {
            return e;
        } else if(nums[e] < target) {
            return e + 1;
        } else if(nums[s] > target) {
            return s;
        }

        return s + 1;
    }
}
// @lc code=end

