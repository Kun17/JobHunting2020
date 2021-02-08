/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int pathLen = 0;
        int ri = -1, ci = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ri = i;
                    ci = j;
                }
                if (grid[i][j] == 0) {
                    pathLen++;
                }
            }
        }
        dfs(grid, ri, ci, pathLen + 1);
        return ret;
    }

    int ret = 0;
    public void dfs(int[][] grid, int i , int j, int pathLen) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }
        if (grid[i][j] == -1) {
            return;
        }
        if(grid[i][j] == 2) {
            if(pathLen == 0) {
                ret++;
            }
            return;
        }

        grid[i][j] = -1;
        pathLen--;
        dfs(grid, i - 1, j, pathLen);
        dfs(grid, i + 1, j, pathLen);
        dfs(grid, i, j - 1, pathLen);
        dfs(grid, i, j + 1, pathLen);
        grid[i][j] = 0;
    }
}
// @lc code=end

