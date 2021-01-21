/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
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
        if(nums[s] == target) return s;
        if(nums[e] == target) return e;
        return -1;
    }
}
// @lc code=end

