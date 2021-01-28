class Solution {
    public void sortColors(int[] nums) {
        for (int pivot = 1; pivot >= 0; pivot--){
            int i = 0;
            int j = nums.length-1;
            while(i < j){
                if (nums[j] > pivot) {
                    j--;
                    continue;
                }
                if (nums[i] > pivot) {
                    swap(nums, i, j);
                    j--;
                }
                i++;
            }
        }
    }

    public void sortColors_dutchFlag(int[] nums) {
        int zP = 0;
        int tP = nums.length-1;
        int i = 0;
        while(i <= tP){
            if(nums[i] == 2) {
                swap(nums, i, tP);
                tP--;
            }
            if(nums[i] == 1) {
                i++;
                continue;
            }
            if(nums[i] == 0) {
                swap(nums, i, zP);
                zP++;
                i++;
            }
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{2,0,1};
        s.sortColors_dutchFlag(nums);
        System.out.println(nums);
    }
}