/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int multiple = 1;
        for (int i = 0; i < nums.length; i++) {
            ret[i] = multiple;
            multiple *= nums[i];
        }

        multiple = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] = ret[i] * multiple;
            multiple *= nums[i];
        }

        return ret;
    }
}
// @lc code=end

