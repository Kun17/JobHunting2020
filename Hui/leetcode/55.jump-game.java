/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
// @lc code=end

