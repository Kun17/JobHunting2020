/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);
        int[] duration = new int[]{1, 7, 30};
        return dfs(0, days, costs, memo, duration);
    }


    public int dfs(int cur, int[] days, int[] costs, int[] memo, int[] duration) {
        if (cur == days.length) {
            return 0;
        }
        if (memo[cur] != -1) return memo[cur];
        
        memo[cur] = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int next = cur;
            while (next < days.length && days[next] < days[cur] + duration[i]) {
                next++;
            }
            memo[cur] = Math.min(memo[cur], dfs(next, days, costs, memo, duration) + costs[i]);
        }

        return memo[cur];
    }
}
// @lc code=end

