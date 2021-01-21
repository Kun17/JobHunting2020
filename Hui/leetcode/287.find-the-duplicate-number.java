/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        for(int num: nums) {
            int index = Math.abs(num);
            if(nums[index] < 0) {
                return index;
            }
            nums[index] *= -1;
        }

        return -1;
    }
}
// @lc code=end

