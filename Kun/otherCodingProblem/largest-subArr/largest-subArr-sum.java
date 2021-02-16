class Solution{
    public int largestSumOfSubArr(int[] nums){
        int max = 0;
        int curMax = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            curMax += nums[i];
            if(curMax < 0) curMax = 0;
            if(curMax > max) max = curMax;
        }
        return max;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{-3, -4, 5, -1, -2, 3, 6};
        int[] nums2 = new int[]{-3, -4, -5, -1, -2, -3, -6};
        System.out.println(s.largestSumOfSubArr(nums));
        System.out.println(s.largestSumOfSubArr(nums2));
    }
}