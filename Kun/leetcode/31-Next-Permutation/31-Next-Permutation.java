import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int pos = len - 1;
        int min = nums[pos];
        for(int i = len - 1; i >= 0; i--){
            if(nums[i] < min){
                int minMax = Integer.MAX_VALUE;
                int posJ = 0;
                for(int j = len-1; j > i; j--){
                    if(nums[j] > nums[i] && minMax > nums[j]) {
                        minMax = nums[j];
                        posJ = j;
                    }
                }
                int temp = nums[posJ];
                nums[posJ] = nums[i];
                nums[i] = temp;
                Arrays.sort(nums, i+1, len);
                pos = i;
                break;
            }
            min = Math.max(nums[i], min);
        }
        if(pos == len - 1) Arrays.sort(nums);
    }

    public static void main(String[] Args){
        int[] nums = new int[]{1,3,2};
        Solution s = new Solution();
        s.nextPermutation(nums);
    }
}