import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int wid = board[0].length, dep = board.length;
        Set<Character>[] colSet = new HashSet[wid];
        Set<Character>[] boxSet = new HashSet[wid*dep/9];
        for(int i = 0; i < wid; i++){
            colSet[i] = new HashSet<>();
        }
        for(int i = 0; i < wid*dep/9; i++){
            boxSet[i] = new HashSet<>();
        }
        for(int i = 0; i < dep; i++){
            Set<Character> rowSet = new HashSet<>();
            for(int j = 0; j < wid; j++){
                char c = board[i][j];
                if(c < '0' || c > '9'){
                    if(c != '.') return false;
                    continue;
                }
                int boxNum = (int)(i/3) * (wid/3) + (int)(j/3);
                if(rowSet.contains(c)) return false;
                if(colSet[j].contains(c)) return false;
                if(boxSet[boxNum].contains(c)) return false;
                rowSet.add(c);
                colSet[j].add(c);
                boxSet[boxNum].add(c);
            }
        }
        return true;
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
        System.out.println(s.isValidSudoku(board));
    }
}