class Solution2 {
    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(dfs(board, i, j, word, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int pos, boolean[][] visited){
        if(pos == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)) return false;
        visited[i][j] = true;
        boolean exist = dfs(board, i + 1, j, word, pos + 1, visited) ||
        dfs(board, i - 1, j, word, pos + 1, visited) ||
        dfs(board, i, j + 1, word, pos + 1, visited) ||
        dfs(board, i, j - 1, word, pos + 1, visited);
        visited[i][j] = false;
        return exist;
    }

    public static void main(String[] Args){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Solution2 s = new Solution2();
        System.out.println(s.exist(board, word));
    }
}