/*
 * @lc app=leetcode id=1473 lang=java
 *
 * [1473] Paint House III
 */

// @lc code=start
class Solution {
int[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new int[m][n][target + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ret = helper(houses, cost, target, 0, -1);
        if (ret == Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }
    
    public int helper(int[] h, int[][] cost, int target, int cur, int prevColor) {
        if (cur == h.length) {
            if (target == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        
        if (target < 0) return Integer.MAX_VALUE;
        // System.out.println(cur + " " + prevColor + " " + target);
        if (prevColor != -1 && dp[cur][prevColor][target] != -1) {
            return dp[cur][prevColor][target];
        }
        
        int minCost = Integer.MAX_VALUE;
        if (h[cur] == 0) {
            for (int i = 0; i < cost[0].length; i++) {
                int subcost = 0;
                if (i == prevColor) {
                    subcost = helper(h, cost, target, cur + 1, i);
                } else {
                    subcost = helper(h, cost, target - 1, cur + 1, i);
                }
                if (subcost == Integer.MAX_VALUE) continue;
                minCost = Math.min(minCost, subcost + cost[cur][i]);
            }
        } else if (h[cur] == prevColor + 1) {
            minCost = helper(h, cost, target, cur + 1, h[cur] - 1);
        } else {
            minCost = helper(h, cost, target - 1, cur + 1, h[cur] - 1);
        }

        if (prevColor != -1) {
            dp[cur][prevColor][target] = minCost;
        }
        return minCost;
    }
}
// @lc code=end

