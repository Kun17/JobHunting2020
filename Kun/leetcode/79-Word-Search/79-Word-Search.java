class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if(dfs(board, i, j, word, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int pos, boolean[][] visited){
        if(pos == word.length() - 1 && word.charAt(pos) == board[i][j]) return true; 
        if(word.charAt(pos) != board[i][j]) {
            return false;
        }
        System.out.printf("you got it right! board[%d][%d] = %c\n", i, j, board[i][j]);
        if (i + 1 < board.length && !visited[i+1][j]){
            visited[i+1][j] = true;
            if(dfs(board, i + 1, j, word, pos + 1, visited)) return true;
            visited[i+1][j] = false;
        }
        if (i - 1 >= 0 && !visited[i-1][j]){
            visited[i-1][j] = true;
            if(dfs(board, i - 1, j, word, pos + 1, visited)) return true;
            visited[i-1][j] = false;
        }
        if (j + 1 < board[0].length && !visited[i][j+1]){
            visited[i][j+1] = true;
            if(dfs(board, i, j + 1, word, pos + 1, visited)) return true;
            visited[i][j+1] = false;
        }
        if (j - 1 >= 0 && !visited[i][j-1]){
            visited[i][j-1] = true;
            if(dfs(board, i, j - 1, word, pos + 1, visited)) return true;
            visited[i][j-1] = false;
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] Args){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Solution s = new Solution();
        System.out.println(s.exist(board, word));
    }
}