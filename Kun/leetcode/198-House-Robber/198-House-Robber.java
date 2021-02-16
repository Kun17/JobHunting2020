class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int len = nums.length;
        dp = new int[len+2];
        for(int i = len -1; i >= 0; i--){
            dp[i] = Math.max(dp[i+1], nums[i] + dp[i+2]);
        }
        return dp[0];
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(s.rob(nums));
    }
}