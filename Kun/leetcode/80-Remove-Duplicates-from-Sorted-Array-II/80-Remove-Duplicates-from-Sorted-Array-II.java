class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int i = 0;
        int count = 1;
        for(int j = 1; j < len; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
                count = 1;
            } else if (count < 2){
                count++;
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}