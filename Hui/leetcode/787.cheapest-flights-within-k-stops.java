/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] memo = new int[n][K + 1];
        int[][] adjacent = new int[n][n];
        for (int[] f: flights) {
            adjacent[f[0]][f[1]] = f[2];
            // adjacent[f[1]][f[0]] = f[2];
        }

        return dfs(n, src, dst, K, adjacent, memo);
    }

    public int dfs(int n, int src, int dst, int k, int[][] adjacent, int[][] memo) {
        if (src == dst) return 0;
        if (k < 0) return -1;
        if (memo[src][k] != 0) return memo[src][k];
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (adjacent[src][i] > 0) {
                int next = dfs(n, i, dst, k - 1, adjacent, memo);
                if (next >= 0) {
                    ret = Math.min(ret, next + adjacent[src][i]);
                }
            }
        }
        if (ret == Integer.MAX_VALUE) {
            memo[src][k] = -1;
        } else {
            memo[src][k] = ret;
        }
        return memo[src][k];
    }
}
// @lc code=end

