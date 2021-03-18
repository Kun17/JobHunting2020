/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0] + costs[i + costs.length / 2][1];
        }

        return sum;
    }
}
// @lc code=end

