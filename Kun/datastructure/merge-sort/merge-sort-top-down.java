

class Solution{
    public int[] mergeSortTopDown(int[] nums){
        splitAndSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void splitAndSort(int[] nums, int start, int end){
        if(start >= end) return;
        int mid = (start + end)/2;
        splitAndSort(nums, start, mid);
        splitAndSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end){
        int l = start, r = mid + 1;
        int[] temp = new int[end - start + 1];
        int tp = 0;
        while(tp < temp.length){
            if(r > end || l <= mid && nums[l] < nums[r]){
                temp[tp++] = nums[l++];
            }
            if(tp == temp.length) break;
            if(l > mid || r <= end && nums[r] <= nums[l]){
                temp[tp++] = nums[r++];
            }
        }
        for(int i = start; i <= end; i++){
            nums[i] = temp[i-start];
        }
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[] nums = new int[]{4,6,2,6,9,0,15,8};
        nums = s.mergeSortTopDown(nums);
        for(int i = 0; i < nums.length; i ++){
            System.out.println(nums[i]);
        }
    }
}