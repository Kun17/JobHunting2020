/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        // hold 
        int[] dp1 = new int[prices.length];
        // not hold
        int[] dp2 = new int[prices.length];
        
        dp1[0] = -prices[0];
        dp1[1] = Math.max(-prices[0], -prices[1]);

        dp2[0] = 0;
        dp2[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < prices.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp2[i - 2] - prices[i]);
            dp2[i] = Math.max(dp2[i - 1], dp1[i - 1] + prices[i]);
        }

        return Math.max(dp1[prices.length - 1], dp2[prices.length - 1]);
    }
}
// @lc code=end

