class Solution {
    public int search(int[] nums, int target) {
        int pivotPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i+1] < nums[i]) {
                pivotPoint = i+1;
                break;
            } 
        }
        int[] newNums = new int[nums.length];
        for (int i = 0; i < newNums.length; i++){
            newNums[i] = nums[(i+pivotPoint)%nums.length];
        }
        int res = binarySearch(newNums, target);
        return (res < 0) ? -1 : (res + pivotPoint) % nums.length;
    }

    private int binarySearch(int[] nums, int target){
        int start  = 0;
        int end = nums.length - 1;
        if (target > nums[nums.length -1] || target < nums[0]) return -1;
        while(start < end) {
            int mid  = (start + end)/2;
            if(nums[mid] < target) {
                if(nums[mid + 1] == target) return mid + 1;
                else if(nums[mid + 1] > target) return -1;
                start = mid;
            }
            else if(nums[mid] > target) end = mid;
            else return mid;
        }
        return (nums[start] == target) ? start: -1;
    }

    public static void main(String[] Args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{3,1}, 3));
    }
}