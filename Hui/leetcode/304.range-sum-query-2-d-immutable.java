/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                if (i == 0) {
                    sums[i][j] = sum;
                } else {
                    sums[i][j] = sums[i - 1][j] + sum;
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = sums[row2][col2];
        if (col1 > 0) {
            ret -= sums[row2][col1 - 1];
        }
        if (row1 > 0) {
            ret -= sums[row1 - 1][col2];
        }
        if (row1 > 0 && col1 > 0) {
            ret += sums[row1 - 1][col1 - 1];
        }
        return ret;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

