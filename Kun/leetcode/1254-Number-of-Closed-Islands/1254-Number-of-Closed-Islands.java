class Solution {
    int width, depth;
    int count = 0;
    public int closedIsland(int[][] grid) {
        depth = grid.length;
        width = grid[0].length;
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 0 && dfs(grid,i,j)) count++;
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int i, int j){
        boolean flag = true;
        if(i < 0 || i > depth - 1 || j < 0 || j > width - 1) return false;
        if(i == 0 || i == depth - 1 || j == 0 || j == width - 1) flag = false;
        if(grid[i][j] == 1) return true;
        grid[i][j] = 1;
        boolean flag1 = dfs(grid, i+1, j);
        boolean flag2 = dfs(grid, i-1, j); 
        boolean flag3 = dfs(grid, i, j+1); 
        boolean flag4 = dfs(grid, i, j-1);
        return flag && flag1 && flag2 && flag3 && flag4;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] grid = new int[][]{
            {0,0,1,0,0},
            {0,1,0,1,0},
            {0,1,1,1,0},
        };

        System.out.println(s.closedIsland(grid));
    }
}