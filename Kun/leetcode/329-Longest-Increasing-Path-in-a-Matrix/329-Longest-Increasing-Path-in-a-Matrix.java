class Solution {
    int[][] memo;
    int dep, wid;
    int res = 0;
    int[][] dirs;
    public int longestIncreasingPath(int[][] matrix) {
        // we use a matrix to store the longest possible path from [i][j]
        // then do a dfs with every i j
        // time complexity should be O(mn)
        // space complexity should be O(mn)
        dep = matrix.length;
        wid = matrix[0].length;
        memo = new int[dep][wid];
        dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i < dep; i++){
            for(int j = 0; j < wid; j++){
                memo[i][j] = dfs(matrix, i, j);
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j){
        if(i < 0 || i >= dep || j < 0 || j >= wid) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        memo[i][j] = 1;

        for(int[] dir: dirs){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI >= 0 && newI < dep && newJ >= 0 && newJ < wid && matrix[i][j] < matrix[newI][newJ]){
                memo[i][j] = Math.max(dfs(matrix, newI, newJ)+1, memo[i][j]);
            }
        }
        res = Math.max(res, memo[i][j]);
        return memo[i][j];
    }
}