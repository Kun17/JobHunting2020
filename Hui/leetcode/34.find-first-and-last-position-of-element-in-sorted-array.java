/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        int s = 0, e = nums.length - 1;
        while(e > s) {
            int mid = s + (e - s) / 2;
            if(nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        if(nums[s] != target) {
            return new int[]{-1, -1};
        }
        int[] ret = new int[2];
        ret[0] = s;

        s = 0; e = nums.length - 1;
        while(e > s) {
            int mid = s + (e - s) / 2;
            if(nums[mid] <= target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if(nums[s] == target) {
            ret[1] = s;
        } else {
            ret[1] = s - 1;
        }

        return ret;
    }
}
// @lc code=end

