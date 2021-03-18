/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    int[][] memo;
    public int findTargetSumWays(int[] nums, int S) {
        memo = new int [nums.length][1000];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(nums, 0, 0, S);
    }

    public int helper(int[] nums, int cur, int sum, int target) {
        if (sum > target || sum < 0) return 0;
        if (cur == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        if (memo[cur][sum] != -1) return memo[cur][sum];
        memo[cur][sum] = 0;
        memo[cur][sum] += helper(nums, cur + 1, sum + nums[cur], target);
        memo[cur][sum] += helper(nums, cur + 1, sum - nums[cur], target);
        return memo[cur][sum];
    }
}
// @lc code=end

