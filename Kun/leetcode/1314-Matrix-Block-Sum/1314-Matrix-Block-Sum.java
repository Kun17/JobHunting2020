class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int dep = mat.length;
        int wid = mat[0].length;
        int[][] memo = new int[dep+1][wid+1];
        for(int i = 1; i <= dep;i++){
            for(int j = 1; j <= wid; j++){
                memo[i][j] = memo[i-1][j] + memo[i][j-1] -memo[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int[][] res = new int[dep][wid];
        for(int i = 0; i < dep; i++){
            for(int j = 0; j < wid; j++){
                int l = (j-K < 0)?0:j-K;
                int r = (j+K > wid-1)?wid:j+K+1;
                int u = (i-K < 0)?0:i-K;
                int d = (i+K > dep-1)?dep:i+K+1;
                res[i][j] = memo[d][r] - memo[d][l] - memo[u][r] + memo[u][l];
            }
        }
        return res;
    }
}