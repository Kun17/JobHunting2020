/*
 * @lc app=leetcode id=1293 lang=java
 *
 * [1293] Shortest Path in a Grid with Obstacles Elimination
 */

// @lc code=start
class Solution {
    int min = Integer.MAX_VALUE;
    int[][][] visited;
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        visited = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        dfs(grid, 0, 0, m - 1, n - 1, k, 0);

        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void dfs(int[][] grid, int i, int j, int tx, int ty, int k, int step) {
        if (k < 0 || i < 0 || i > tx || j < 0 || j > ty || step >= min) return;
        if (grid[i][j] == -1 || step >= visited[i][j][k]) return;
        if (i == tx && j == ty) {
            min = Math.min(min, step);
            return;
        }
        
        visited[i][j][k] = step;

        int obstacle = grid[i][j];
        if (obstacle == 1) {
            k = k - 1;
        }
        dfs(grid, i + 1, j, tx, ty, k, step + 1);
        dfs(grid, i, j + 1, tx, ty, k, step + 1);
        dfs(grid, i - 1, j, tx, ty, k, step + 1);
        dfs(grid, i, j - 1, tx, ty, k, step + 1);

        grid[i][j] = obstacle;
    }


}
// @lc code=end

