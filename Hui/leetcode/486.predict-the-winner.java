/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][][] dp = new int[nums.length][nums.length][2];
        if(nums.length == 1) return true;
        int[] ret = helper(nums, 0, nums.length - 1, dp);

        return ret[0] >= ret[1];
    }

    public int[] helper(int[] nums, int start, int end, int[][][] dp) {
        if(dp[start][end][0] != 0) {
            return dp[start][end];
        }
        if(end - start == 1) {
            dp[start][end] =  new int[]{Math.max(nums[start], nums[end]), Math.min(nums[start], nums[end])};
        } else {
            int[] ret1 = helper(nums, start + 1, end, dp);
            int[] ret2 = helper(nums,start, end - 1, dp);

            if(ret1[1] + nums[start] > ret2[1] + nums[end]) {
                dp[start][end] = new int[]{ret1[1] + nums[start], ret1[0]};
            } else {
                dp[start][end] = new int[]{ret2[1] + nums[end], ret2[0]};
            }
        }
        return dp[start][end];
    }
}
// @lc code=end

