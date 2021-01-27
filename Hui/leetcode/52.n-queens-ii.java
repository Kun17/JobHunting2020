/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    int ret = 0;
    public int totalNQueens(int n) {
        int[] used = new int[n];
        Arrays.fill(used, -1);
        helper(n, 0, used);
        return ret;
    }

    public void helper(int n, int row, int[] used) {
        if(row == n) {
            ret++;
            return;
        }

        for(int col = 0; col < n; col++) {
            if(used[col] != -1) {
                continue;
            }
            // check diagonal
            boolean valid = true;
            for(int dist = 0; dist <= row; dist++) {
                if(col - dist >= 0 && used[col - dist] == row - dist) {
                    valid = false;
                    break;
                }
                if(col + dist < n && used[col + dist] == row - dist) {
                    valid = false;
                    break;
                }
            }

            if(!valid) {
                continue;
            }

            used[col] = row;
            helper(n, row + 1, used);
            used[col] = -1;
        }
    }
}
// @lc code=end

