/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean containOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                containOne = true;
            }
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        if (!containOne) return 1;
        if (nums.length == 1) return 2;
        for (int num: nums) {
            int idx = Math.abs(num) % nums.length;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return nums.length;

        return nums.length + 1;
    }
}
// @lc code=end

