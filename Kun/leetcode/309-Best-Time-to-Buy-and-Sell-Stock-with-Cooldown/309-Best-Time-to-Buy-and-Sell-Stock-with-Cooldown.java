class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int reset_pre = 0;
        int held_pre = Integer.MIN_VALUE;
        int sold_pre = Integer.MIN_VALUE;
        int held = held_pre, sold = sold_pre, reset = reset_pre;
        for(int i = 0; i < len; i++){
            held = Math.max(reset_pre - prices[i], held_pre);
            reset = Math.max(reset_pre, sold_pre);
            if(i != 0) sold = held_pre + prices[i];
            held_pre = held;
            sold_pre = sold;
            reset_pre = reset;
        }
        return Math.max(reset, sold);
    }
}