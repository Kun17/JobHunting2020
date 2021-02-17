/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int[] row = new int[]{-1, 0, 1};
        int[] col = new int[]{-1, 0, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int ones = 0;
                for (int r: row) {
                    for (int c: col) {
                        if (c == 0 && r == 0) continue;
                        if (i + r == -1 || i + r == board.length || j + c == -1 || j + c == board[0].length || board[i + r][j + c] <= 0) {
                            continue;
                        }
                        ones++;
                    }
                }
                if (board[i][j] == 0) {
                    board[i][j] = -ones;
                } else {
                    if (ones == 0) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = ones;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -3) {
                    board[i][j] = 1;
                } else if (board[i][j] > 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end

