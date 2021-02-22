// Time complexity: 3^(n^2)
// space complexity: n^2
class Solution {
    int res = Integer.MAX_VALUE;
    int n = 0;
    boolean[][] visited;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        visited = new boolean[n][n];
        dfs(grid, 0, 0, grid[0][0], visited);
        return res;
    }

    private void dfs(int[][] grid, int i, int j, int curMax, boolean[][] visited){
        if(i < 0 || i >= n || j < 0 || j >= n) return;
        if(visited[i][j]) return;
        curMax = Math.max(curMax, grid[i][j]);
        if(i == n-1 && j == n-1) res = Math.min(curMax, res);
        visited[i][j] = true;
        dfs(grid, i+1, j, curMax, visited);
        dfs(grid, i-1, j, curMax, visited);
        dfs(grid, i, j+1, curMax, visited);
        dfs(grid, i, j-1, curMax, visited);
        visited[i][j] = false;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] grid = new int[][]{
            {0,2},
            {1,3}
        };
        System.out.println(s.swimInWater(grid));
    }
}