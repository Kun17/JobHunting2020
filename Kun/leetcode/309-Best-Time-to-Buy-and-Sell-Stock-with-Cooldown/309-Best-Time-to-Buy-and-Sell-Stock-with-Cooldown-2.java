class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] MP = new int[len+1];
        for(int i = len - 2; i >= 0; i--){
            for(int j = i + 1; j + 2 <= len; j++){
                MP[i] = Math.max(prices[j] - prices[i] + MP[j+2], MP[i]);
            }
            MP[i] = Math.max(MP[i+1], MP[i]);
        }
        return MP[0];
    }
}