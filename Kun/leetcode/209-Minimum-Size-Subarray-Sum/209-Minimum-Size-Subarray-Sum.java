class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // We can use 2 pointers to find the result
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLen = nums.length;
        while (j != nums.length){
            while (j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if (i==0 && sum < s) return 0;
            minLen = Math.min(j-i, minLen);
            while (i < j && sum >= s){
                sum -= nums[i];
                i++;
            }
            minLen = Math.min(j-i+1, minLen);
        }
        return minLen;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}