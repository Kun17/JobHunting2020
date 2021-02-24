class TicTacToe {

    /** Initialize your data structure here. */
    int[][] grid;
    int n;
    public TicTacToe(int n) {
        this.grid = new int[n][n];
        this.n = n;
    }
    
//     /** Player {player} makes a move at ({row}, {col}).
//         @param row The row of the board.
//         @param col The column of the board.
//         @param player The player, can be either 1 or 2.
//         @return The current winning condition, can be either:
//                 0: No one wins.
//                 1: Player 1 wins.
//                 2: Player 2 wins. */
//     public int move(int row, int col, int player) {
//         grid[row][col] = player;

//         boolean win = true;
//         for (int i = 0; i < n && win; i++) {
//             if (grid[row][i] != player) {
//                 win = false;
//             }
//         }
//         if (win) return player;
        
//         win = true;
//         for (int i = 0; i < n && win; i++) {
//             if (grid[i][col] != player) {
//                 win = false;
//             }
//         }
//         if (win) return player;
        
//         if (col == row) {
//             win = true;
//             for (int i = 0; i < n && win; i++) {
//                 if (grid[i][i] != player) {
//                     win = false;
//                 }
//             }
//             if (win) return player;
//         }
        
//         if (row + col == n - 1) {
//             win = true;
//             for (int i = 0; i < n && win; i++) {
//                 if (grid[i][n - i - 1] != player) {
//                     win = false;
//                 }
//             }
//             if (win) return player;
//         }

//         return 0;
//     }
    
    boolean check(int row, int col, int dirX, int dirY, int player) {
        for (int i = 0; i < n; ++i) {
            if (grid[row][col] != player) {
                return false;
            }
            row = (row + dirX + n) % n;
            col = (col + dirY + n) % n;
        }
        return true;
    }
    public int move(int row, int col, int player) {
        grid[row][col] = player;
        if (check(row, col, 1, 0, player)) return player;
        if (check(row, col, 0, 1, player)) return player;
        if (row == col && check(row, col, 1, 1, player)) return player;
        if (row + col == n - 1 && check(row, col, 1, -1, player)) return player;
        return 0;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
