class NumMatrix {

    int[][] memo;
    public NumMatrix(int[][] matrix) {
        int dep = matrix.length;
        if(dep == 0) return;
        int wid = matrix[0].length;
        memo = new int[dep+1][wid+1];
        for(int i = 1; i <= dep; i++){
            for(int j = 1; j <= wid; j++){
                memo[i][j] = memo[i-1][j] + memo[i][j-1] - memo[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(memo.length == 0) return 0;
        return memo[row2+1][col2+1] - memo[row2+1][col1] - memo[row1][col2+1] + memo[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */