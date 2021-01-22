/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            }
            if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
// @lc code=end

