class Solution2 {
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
        // time complexity: mnk
        // space complexity: mn
        int dep = matrix.length;
        int wid = matrix[0].length;
        dp = new int[dep+1][wid+1];
        int res = 0;
        for(int i = 0; i < dep; i++){
            for(int j = 0; j < wid; j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j])) + 1;
                }
                res = Math.max(dp[i+1][j+1], res);
            }
        }
        return res * res;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        char[][] matrix = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','1','1','0'},
            {'1','1','1','1','1'},
            {'1','1','1','1','1'},
            {'0','0','1','1','1'}
        };
        System.out.println(s.maximalSquare(matrix));
    }
}