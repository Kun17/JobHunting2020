class Solution {
    public int maxSumAfterOperation(int[] nums) {
        if (nums.length == 1) return nums[0] * nums[0];
        int n = nums.length;
        int[] maxLeft = new int[n];
        maxLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1] + nums[i], nums[i]); 
        }
        
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1] + nums[i], nums[i]);
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int left = 0;
            if (0 < i) {
                left = Math.max(left, maxLeft[i - 1]);
            }
            int right = 0;
            if (i < n - 1) {
                right = Math.max(right, maxRight[i + 1]);
            }
            max = Math.max(max, left + nums[i] * nums[i] + right);
        }
        
        return max;
    }
}
