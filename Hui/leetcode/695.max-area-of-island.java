/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null) return 0;
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int area = area(grid, i, j);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int area(int[][] grid, int i, int j) {
        if(i == -1 || i == grid.length || j == -1 || j == grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int area = 1;
        area += area(grid, i - 1, j);
        area += area(grid, i, j - 1);
        area += area(grid, i, j + 1);
        area += area(grid, i + 1, j);

        return area;
    }
}
// @lc code=end

