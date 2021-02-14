class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for(int i = 1; i < len; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}