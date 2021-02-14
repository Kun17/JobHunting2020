class Solution2 {
    // space complexity O(n)
    // time complexity O(n)
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        int len = prices.length;
        for(int i = 0; i < len; i++){
            minprice = Math.min(prices[i], minprice);
            if(prices[i] > minprice){
                maxprofit = Math.max(maxprofit, prices[i] - minprice);
            }
        }
        return maxprofit;
    }
}