class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean hasOne = false;
        for(int i = 0; i < len; i++){
            if(nums[i] == 1) hasOne = true;
            else if(nums[i] <= 0 || nums[i] > len) nums[i] = 1;
        }
        if(!hasOne) return 1;
        for(int i = 0; i < len; i++){
            if(nums[i] > 0 && nums[nums[i]-1] > 0) nums[nums[i]-1] = -nums[nums[i]-1];
            else if(nums[i] < -1 && nums[-nums[i]-1] > 0) nums[-nums[i]-1] = -nums[-nums[i]-1];
        }
        for(int i = 1; i < len; i++){
            if(nums[i] > 0) return i+1;
        }
        return len+1;
    }

    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        int i = 0;
        while(i < len){
            int j = nums[i] - 1;
            if(j >= 0 && j < len && nums[j] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else ++i;
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i+1) return i+1;
        }
        return len + 1;
    }
}