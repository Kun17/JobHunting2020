/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < prev.length; i++) {
            prev[i] = i;
        }

        int idx = 0;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            // System.out.println(i + " dp[i]=" + dp[i]);
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                idx = i;
            }
        }
        // System.out.println(idx);
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(nums[idx]);
        while (prev[idx] != idx) {
            idx = prev[idx];
            ret.add(nums[idx]);
        }

        return ret;
    }
}
// @lc code=end

