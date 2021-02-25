class Solution{
    public int[][] PrefixSum(int a[][]){
        int wid = a[0].length;
        int dep = a.length;

        int[][] memo = new int[dep+1][wid+1];
        for(int i = 1; i <= dep; i++){
            for(int j = 1; j <= wid; j++){
                memo[i][j] = a[i-1][j-1] + memo[i-1][j] + memo[i][j-1] - memo[i-1][j-1];
            }
        }
        int[][] res = new int[dep][wid];
        for(int i = 0; i < dep; i++){
            for(int j =0; j < wid; j++){
                res[i][j] = memo[i+1][j+1];
            }
        }
        return res;
    }

    public static void main(String[] Args){
        int[][] a = {{1, 1, 1, 1, 1 },
                    { 1, 1, 1, 1, 1 },
                    { 1, 1, 1, 1, 1 },
                    { 1, 1, 1, 1, 1 } };
        Solution s = new Solution();
        int[][] res = s.PrefixSum(a);
        for(int[] row: res){
            for(int ele: row){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
