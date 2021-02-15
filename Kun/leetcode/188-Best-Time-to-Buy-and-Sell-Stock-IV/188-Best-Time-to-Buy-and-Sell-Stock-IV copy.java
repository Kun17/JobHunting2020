class Solution2 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len <= 1 || k < 1) return 0;
        int[][][] dp = new int[len][k+1][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -1000000000;
                dp[i][j][1] = -1000000000;
            }
        }

        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
        for(int i = 0; i < len; i++){
            dp[i][0][1] = Integer.MIN_VALUE;
            dp[i][0][0] = 0;
        }

        for(int i = 1; i < len; i++){
            for(int j = 1; j <= i/2 + 1 && j <= k; j++){
                dp[i][j][1] = Math.max(dp[i][j-1][0] - prices[i], dp[i-1][j][1]);
                dp[i][j][0] = Math.max(dp[i][j][1] + prices[i], dp[i-1][j][0]);
            }
        }

        int maxProfit = 0;
        for(int i = 1; i <= k; i++){
            maxProfit = Math.max(dp[len-1][i][0], maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] Args){
        int[] prices = new int[]{1,3,2,8,4,9};
        Solution2 s = new Solution2();
        System.out.println(s.maxProfit(2, prices));
    }
}