class Solution {
    int[][] area;
    public int maximalSquare(char[][] matrix) {
        // time complexity: mnk
        // space complexity: mn
        int dep = matrix.length;
        int wid = matrix[0].length;
        area = new int[dep+1][wid+1];
        int res = 0;
        for(int i = 0; i < dep; i++){
            for(int j = 0; j < wid; j++){
                area[i+1][j+1] = area[i][j+1] + area[i+1][j] - area[i][j] + (int)(matrix[i][j]-'0');
                if(area[i+1][j+1] > res){
                    int len = Math.min(i, j) + 1;
                    for(int k = 1; k <= len; k++){
                        int squareArea = area[i+1][j+1] - area[i+1-k][j+1] - area[i+1][j+1-k] + area[i+1-k][j+1-k];
                        if(squareArea == k*k) {
                            res = Math.max(squareArea, res);
                        }
                    }
                }
            }
        }
        return res;
    }
}