/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }

        if (sum % 2 != 0) return false;
        
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int n: nums) {
            for (int s = dp.length - 1; s >= 0; s--) {
                if (s - n < 0) continue;
                dp[s] = (dp[s] || dp[s - n]) ;
            }
        }

        // int i = 0;
        // for (boolean b: dp) {
        //     System.out.println(i++ + ", " + b);
        // }
        return dp[dp.length - 1];
    }
}
// @lc code=end

