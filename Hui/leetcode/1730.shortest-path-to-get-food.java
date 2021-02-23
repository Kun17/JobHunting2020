class Solution {
    public int getFood(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] visited = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    break;
                }
            }
        }
        
        int dist = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (grid[cur[0]][cur[1]] == '#') {
                    return dist;
                }
                
                for (int[] d: dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x == -1 || x == m || y == -1 || y == n || grid[x][y] == 'X' || visited[x][y] == 1) {
                        continue;
                    }
                    queue.add(new int[]{x, y});
                    visited[x][y] = 1;
                }
                
            }
            dist++;
        }
        
        return -1;
    }
}
