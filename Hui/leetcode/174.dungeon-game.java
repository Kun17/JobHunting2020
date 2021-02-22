/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] dp = new int[height][width];
        for (int i = height - 1; i >= 0; i--) {
            for (int j = width - 1; j >= 0; j--) {
                int right = Integer.MAX_VALUE;
                if (j < width - 1) {
                    right = dp[i][j + 1];
                }
                int down = Integer.MAX_VALUE;
                if (i < height - 1) {
                    down = dp[i + 1][j];
                }

                int minHp = Math.min(right, down);
                dp[i][j] = Math.max(1, (minHp == Integer.MAX_VALUE ? 1 : minHp) - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}
// @lc code=end

