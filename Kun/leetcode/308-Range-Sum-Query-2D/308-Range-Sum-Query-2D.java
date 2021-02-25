class NumMatrix {

    int[][] memo;
    int dep, wid;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        dep = matrix.length;
        if(dep == 0) return;
        wid = matrix[0].length;
        memo = new int[dep+1][wid+1];
        for(int i = 1; i <= dep; i++){
            for(int j = 1; j <= wid; j++){
                memo[i][j] = memo[i-1][j] + memo[i][j-1] - memo[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        for(int i = row+1; i <= dep; i++){
            for(int j = col+1; j <= wid; j++){
                memo[i][j] += val - matrix[row][col];
            }
        }
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(memo.length == 0) return 0;
        return memo[row2+1][col2+1] - memo[row2+1][col1] - memo[row1][col2+1] + memo[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */