/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[s]) {
                if (target < nums[mid] && nums[s] <= target) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return -1;
    }

    // public int search(int[] nums, int target) {
    //     int s = 0, e = nums.length - 1;
    //     while(e - s > 1) {
    //         int mid = s + (e - s) / 2;
    //         if(nums[mid] > nums[0]) {
    //             s = mid;
    //         } else {
    //             e = mid;
    //         }
    //     }

    //     int ri = -1;
    //     if(nums[s] <= nums[e]) {
    //         ri = e;
    //     } else {
    //         ri = s;
    //     }

    //     if(target >= nums[0]) {
    //         s = 0;
    //         e = ri;
    //     } else {
    //         s = (ri + 1) % nums.length;
    //         e = nums.length - 1;
    //     }

    //     while(e - s > 1) {
    //         int mid = s + (e - s) / 2;
    //         if(nums[mid] == target) {
    //             return mid;
    //         } else if(nums[mid] > target) {
    //             e = mid;
    //         } else {
    //             s = mid;
    //         }
    //     }

    //     if(nums[s] == target) return s;
    //     if(nums[e] == target) return e;

    //     return -1;
    // }
}
// @lc code=end

