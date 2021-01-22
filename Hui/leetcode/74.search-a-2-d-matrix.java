/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int s = 0;
        int e = m * n - 1;
        while(e - s > 1) {
            int mid = s + (e - s) / 2;
            if(findNum(matrix, mid) == target) {
                return true;
            }
            if(findNum(matrix, mid) < target) {
                s = mid;
            } else {
                e = mid;
            }
        }

        return findNum(matrix, s) == target || findNum(matrix, e) == target;
    }

    public int findNum(int[][] m, int pos) {
        return m[pos / m[0].length][pos % m[0].length];
    }
}
// @lc code=end

