class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dpStart = new int[len], dpEnd = new int[len];
        int maxStart = 0;
        int minEnd = Integer.MAX_VALUE;
        for(int i = 1; i < len; i++){
            minEnd = Math.min(prices[i-1], minEnd);
            dpEnd[i] = Math.max(dpEnd[i-1], prices[i] - minEnd);

            maxStart = Math.max(prices[len - i], maxStart);
            dpStart[len - 1 - i] = Math.max(maxStart - prices[len - 1 - i], dpStart[len - i]);
        }
        int maxProfit = 0;
        for(int i = 0; i < len - 1; i++){
            maxProfit = Math.max(dpEnd[i] + dpStart[i+1], maxProfit);
        }
        maxProfit = Math.max(maxProfit, dpStart[0]);
        maxProfit = Math.max(maxProfit, dpEnd[len - 1]);
        return maxProfit;
    }

    public static void main(String[] Args){
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
}