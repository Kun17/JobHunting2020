class Solution {
    public int[] sortArray(int[] nums) {
        // Let's try with QuickSort 
        // we always pick the last element as pivot
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int s, int e){
        if(s < e){
            int p = partition(nums, s, e);
            quickSort(nums, s, p-1);
            quickSort(nums, p+1, e);
        }
    }
    
    private int partition(int[] nums, int s, int e){
        int pivot = nums[e];
        int i = s;
        for(int j = s; j <= e; j++){
            if(nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, e);
        return i;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}