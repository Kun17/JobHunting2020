

class Solution2{
    public int[] mergeSortBottomUp(int[] nums){
        for(int width = 1; width < nums.length; width *= 2){
            for(int i = 0; i < nums.length; i += width * 2){
                int end = Math.min(i + width * 2 - 1, nums.length - 1);
                int mid = (i + end)/2;
                merge(nums, i, mid, end);
            }
        }
        return nums;
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
        Solution2 s = new Solution2();
        int[] nums = new int[]{4,6,2,6,9,0,15,8};
        nums = s.mergeSortBottomUp(nums);
        for(int i = 0; i < nums.length; i ++){
            System.out.println(nums[i]);
        }
    }
}