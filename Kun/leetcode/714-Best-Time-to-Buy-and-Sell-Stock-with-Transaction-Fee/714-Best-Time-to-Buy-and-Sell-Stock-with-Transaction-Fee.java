class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int rest = 0, hold = -prices[0] - fee;
        for(int i = 1; i < len; i++){
            hold = Math.max(hold, rest - prices[i] - fee);
            rest = Math.max(hold + prices[i], rest);
        }
        return rest;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] prices  = new int[]{1,3,2,8,4,9};
        System.out.println(s.maxProfit(prices, 2));
    }
}