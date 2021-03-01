class Solution {
    public int maxSubArray(int[] nums) {
        // we start from pos 0, if sum comes to below 0, we start from next pos
        int len = nums.length;
        int sum = 0;
        int res = -100001;
        for(int i = 0; i < len; i++){
            sum += nums[i];
            res = Math.max(res, sum);
            if(sum < 0) sum = 0;
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        // Let's try with DAC
        int len = nums.length;
        int[] dp = new int[len+1];
        int res = -100001;
        for(int i = 1; i <= len; i++){
            dp[i] = Math.max(dp[i-1]+nums[i-1], nums[i-1]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}