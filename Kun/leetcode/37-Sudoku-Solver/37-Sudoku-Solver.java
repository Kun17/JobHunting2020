class Solution {
    char[] kcarr = new char[]{'1','2','3','4','5','6','7','8','9'};
    int[][] rowSet = new int[9][10];
    int[][] colSet = new int[9][10];
    int[][] boxSet = new int[9][10];
    int count = 0;
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.') {count++; continue;}
                int boxNum = (int)(i/3) * 3 + (int)(j/3);
                int ic = c - '0';
                rowSet[i][ic]++;
                colSet[j][ic]++;
                boxSet[boxNum][ic]++;
            }
        }
        
        bktk(0, 0, board);
        System.out.println("haha");
    }
    
    boolean bktk(int x, int y, char[][] board){
        if(count == 0) return true;
        for(int i = x; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.') continue;
                int boxNum = (int)(i/3) * 3 + (int)(j/3);
                for(int k = 1; k <= 9; k++){
                    if(rowSet[i][k] == 0 && colSet[j][k] == 0 && boxSet[boxNum][k] == 0){
                        rowSet[i][k]++;
                        colSet[j][k]++;
                        boxSet[boxNum][k]++;
                        board[i][j] = kcarr[k-1];
                        count--;
                        if(bktk(i, j+1, board)) return true;
                        rowSet[i][k]--;
                        colSet[j][k]--;
                        boxSet[boxNum][k]--;
                        board[i][j] = '.';
                        count++;                       
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] Args){
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        Solution s = new Solution();
        s.solveSudoku(board);
    }
}