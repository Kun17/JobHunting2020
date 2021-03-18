/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!check(0, i, 1, 0, board)) return false;
            if (!check(i, 0, 0, 1, board)) return false;

        }
        // if (!check(0, 0, 1, 1, board)) return false;
        // if (!check(0, 8, 1, -1, board)) return false;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int[] seen = new int[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[x * 3 + i][y * 3 + j] != '.') {
                            if (seen[board[x * 3 + i][y * 3 + j] - '0'] == 1) {
                                return false;
                            }
                            seen[board[x * 3 + i][y * 3 + j] - '0'] = 1;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean check(int x, int y, int dx, int dy, char[][] board) {
        // System.out.println();
        int[] seen = new int[10];
        while (0 <= x && x < 9 && 0 <= y && y < 9) {
            // System.out.print(x + "-" + y + " ");
            if (board[x][y] != '.') {
                if (seen[board[x][y] - '0'] == 1) {
                    return false;
                }
                seen[board[x][y] - '0'] = 1; 
            }
            x += dx;
            y += dy;
        }

        return true;
    }
    // [[".",".","4",".",".",".","6","3","."],[".",".",".",".",".",".",".",".","."],["5",".",".",".",".",".",".","9","."],[".",".",".","5","6",".",".",".","."],["4",".","3",".",".",".",".",".","1"],[".",".",".","7",".",".",".",".","."],[".",".",".","5",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."]]
    // [[".",".",".",".",".",".",".",".","2"],[".",".",".",".",".",".","6",".","."],[".",".","1","4",".",".","8",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".","3",".",".",".","."],["5",".","8","6",".",".",".",".","."],[".","9",".",".",".",".","4",".","."],[".",".",".",".","5",".",".",".","."]]

}
// @lc code=end

