class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums, target);
        if(pos < 0) return new int[]{-1, -1};
        int i = pos, j = pos;
        int len = nums.length;
        while(i-1>=0 && nums[i-1] == target) --i;
        while(j+1 < len && nums[j+1] == target) ++j;
        return new int[]{i, j};
    }
    
    int binarySearch(int[] nums, int target){
        int len = nums.length;
        int l = 0, r = len - 1;
        while(l <= r){
            int mid = (r+l)/2;
            if(nums[mid] < target) l = mid + 1;
            else if(nums[mid] > target) r = mid - 1;
            else return mid;
        }
        return -1;
    }
}