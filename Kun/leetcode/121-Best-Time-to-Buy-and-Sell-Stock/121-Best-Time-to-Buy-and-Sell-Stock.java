class Solution {
    // space complexity O(n)
    // time complexity O(n)
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int max = 0;
        int len = prices.length;
        for(int i = 1; i < len; i++){
            int profit = prices[i] - prices[i-1] + dp[i-1];
            if(profit > 0) dp[i] = profit;
            else dp[i] = 0;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] Args){
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
}