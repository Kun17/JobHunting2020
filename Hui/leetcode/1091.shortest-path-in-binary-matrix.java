/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<int[]>();
        if (grid[0][0] == 0) {
            q.add(new int[]{0, 0});
            visited[0][0] = 1;
        }
        
        int[] xs = new int[]{-1, 0, 1};
        int[] ys = new int[]{-1, 0, 1};
        int dist = 0;
        while (q.size() > 0) {
            dist++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == grid.length - 1 && cur[1] == grid.length - 1) {
                    return dist;
                }
                for (int x: xs) {
                    for (int y: ys) {
                        int[] next = new int[]{cur[0] + x, cur[1] + y};
                        if (next[0] == -1 || next[0] == grid.length || next[1] == -1 || next[1] == grid.length || grid[next[0]][next[1]] == 1 || visited[next[0]][next[1]] == 1) {
                            continue;
                        }
                        q.add(next);
                        visited[next[0]][next[1]] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
}
// @lc code=end

