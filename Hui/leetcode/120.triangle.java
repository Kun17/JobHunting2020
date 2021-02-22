/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            // System.out.println(i + " -------");
            int[] nextDP = new int[triangle.get(n - 1).size()];
            for (int j = 0; j < triangle.get(i).size(); j++) {
                nextDP[j] = Integer.MAX_VALUE;
                if (j < triangle.get(i).size() - 1) {
                    nextDP[j] = dp[j] + triangle.get(i).get(j);
                }
                if (j > 0) {
                    nextDP[j] = Math.min(nextDP[j], dp[j - 1] + triangle.get(i).get(j));
                }
                // System.out.print(nextDP[j] + " ");
            }
            dp = nextDP;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }
}
// @lc code=end

