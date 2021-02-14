/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][][] box = new boolean[3][3][10];
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];

        List<int[]> empty = new ArrayList<int[]>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    empty.add(new int[]{i, j});
                } else {
                    int num = (int) (board[i][j] - '0');
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3][j / 3][num] = true;
                }
            }
        }

        dfs(board, box, row, col, empty, 0);
    }

    public boolean dfs(char[][] board, boolean[][][] box, boolean[][] row, boolean[][] col, List<int[]> empty, int cur) {
        if (cur == empty.size()) {
            return true;
        }

        int[] pos = empty.get(cur);
        for (int n = 1; n <= 9; n++) {
            // check box
            if (box[pos[0] / 3][pos[1] / 3][n]) {
                continue;
            }
            if (row[pos[0]][n]) {
                continue;
            }
            if (col[pos[1]][n]) {
                continue;
            }

            board[pos[0]][pos[1]] = (char) ('0' + n);
            box[pos[0] / 3][pos[1] / 3][n] = true;
            row[pos[0]][n] = true;
            col[pos[1]][n] = true;
            if (dfs(board, box, row, col, empty, cur + 1)) {
                return true;
            }
            box[pos[0] / 3][pos[1] / 3][n] = false;
            row[pos[0]][n] = false;
            col[pos[1]][n] = false;
        }
        return false;
    }
}
// @lc code=end

