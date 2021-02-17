/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] == nums[s]) s++;
            else if (nums[mid] > nums[s]) {
                if (target >= nums[s] && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (target <= nums[e] && target > nums[mid]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            
        }
        return  false;
    } //[1,0,1,1,1]\n0
}
// @lc code=end

