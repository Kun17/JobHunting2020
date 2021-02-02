/*
 * @lc app=leetcode id=1219 lang=java
 *
 * [1219] Path with Maximum Gold
 */

// @lc code=start
class Solution {
    /*
    Time: O(M^2N^2)
    Space: O(MN)
    */
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    int gold = dfs(grid, i, j, dirs);
                    max = Math.max(max, gold);
                } 
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j, int[][] dirs) {
        if(i == -1 || i == grid.length || j == - 1 || j == grid[0].length) {
            return 0;
        }
        if(grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];
        int maxGold = gold;
        grid[i][j] = 0;
        for(int[] d : dirs) {
            maxGold = Math.max(maxGold, gold + dfs(grid, i + d[0], j + d[1], dirs));
        }
        grid[i][j] = gold;

        return maxGold;
    }
}
// @lc code=end

