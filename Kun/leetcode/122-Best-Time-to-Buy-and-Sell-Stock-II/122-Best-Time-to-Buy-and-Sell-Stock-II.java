class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int i = 1;
        int localMax = prices[0];
        int localMin = prices[0];
        int profit = 0;
        while(i < len){
            while(i < len && prices[i] >= prices[i-1]){
                i++;
            }
            localMax = prices[i-1];
            profit += localMax - localMin;
            while(i < len && prices[i] < prices[i-1]){
                i++;
            }
            localMin = prices[i-1];
        }
        return profit;
    }
}