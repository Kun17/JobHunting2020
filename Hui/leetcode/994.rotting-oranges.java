/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;

        int dist = -1;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d: dirs) {
                    int[] next = new int[]{cur[0] + d[0], cur[1] + d[1]};
                    if (next[0] < 0 || next[0] >= m || next[1] < 0 || next[1] >= n) continue;
                    if (grid[next[0]][next[1]] != 1 || visited[next[0]][next[1]] == 1) continue;
                    fresh--;
                    queue.add(next);
                    visited[next[0]][next[1]] = 1; 
                }
            }
            dist++;
        }
        
        if (fresh > 0) return -1;
        return dist;
    }
}
// @lc code=end

