class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            int sum = 0;
            for(int j = i; j < len; j++){
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int nums[] = new int[]{1,1,1};
        System.out.println(s.subarraySum(nums, 2));
    }
}