class Solution {
    public int[][] candyCrush(int[][] board) {
        boolean stable = false;
        
        while (!stable) {
            stable = crush(board);
        }
        
        return board;
    }
    
    
    public boolean crush(int[][] board) {
        boolean crush = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;
                int val = Math.abs(board[i][j]);
                if (i > 0 && i < board.length - 1 && Math.abs(board[i-1][j]) == val && Math.abs(board[i + 1][j]) == val) {
                    board[i-1][j] = -val;
                    board[i+1][j] = -val;
                    board[i][j] = -val;
                    crush = true;
                }
                
                if (j > 0 && j < board[0].length - 1 && Math.abs(board[i][j-1]) == val && Math.abs(board[i][j+1]) == val) {
                    board[i][j-1] = -val;
                    board[i][j+1] = -val;
                    board[i][j] = -val;
                    crush = true;
                }
            }
        }
                    
        for (int c = 0; c < board[0].length; c++) {
            int next = board.length - 1;
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][c] > 0) {
                    board[next][c] = board[i][c];
                    next--;
                }
            }
            // for (int i = board.length - 1; i >= 0; i--) {
            //     if (board[i][c] < 0) {
            //         board[i][c] = 0;
            //     }
            // }
            while (next >= 0) {
                board[next][c] = 0;
                next--;
            }
        }
                    
        return crush == false;
    }
}
