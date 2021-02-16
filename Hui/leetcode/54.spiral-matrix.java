/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ret = new ArrayList<Integer>();
        int rlow = 0, rhigh = m - 1;
        int clow = 0, chigh = n - 1;

        while(rlow <= rhigh && clow <= chigh) {
            for(int c = clow; c <= chigh && ret.size() < m * n; c++) {
                ret.add(matrix[rlow][c]);
            }

            rlow++;

            for(int r = rlow; r <= rhigh && ret.size() < m * n; r++) {
                ret.add(matrix[r][chigh]);
            }

            chigh--;

            for(int c = chigh; c >= clow && ret.size() < m * n; c--) {
                ret.add(matrix[rhigh][c]);
            }

            rhigh--;

            for(int r = rhigh; r >= rlow && ret.size() < m * n; r--) {
                ret.add(matrix[r][clow]);
            }

            clow++;
        }
        
        return ret;
    }
}
// @lc code=end

