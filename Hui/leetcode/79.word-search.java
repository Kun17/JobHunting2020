/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int pos) {
        if(pos == word.length()) {
            return true;
        }

        if(i == -1 || i == board.length || j == -1 || j == board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }
        
        char ch = board[i][j];
        board[i][j] = '.';
        if(dfs(board, i + 1, j, word, pos + 1)) return true;
        if(dfs(board, i - 1, j, word, pos + 1)) return true;
        if(dfs(board, i, j - 1, word, pos + 1)) return true;
        if(dfs(board, i, j + 1, word, pos + 1)) return true;
        board[i][j] = ch;
        
        return false;
    }
}
// @lc code=end

