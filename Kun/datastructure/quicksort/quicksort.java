class quicksort{
    private void sort(int[] nums, int s, int e){
        //partition the arr 
        //pos is the location of pivot
        if (s >= e) return;
        int pos = partition(nums, s, e);
        sort(nums, s, pos-1);
        sort(nums, pos+1, e);
    }

    private int partition(int[] nums, int s, int e){
        int pIdx = e;
        int firstLarger = 0;
        for (int i = s; i < e; i++){
            if (nums[i] < nums[pIdx]) {
                swap(nums, i, firstLarger);
                firstLarger++;
            }
        }
        swap(nums, firstLarger, pIdx);
        return pIdx;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] Args){
        quicksort q = new quicksort();
        int[] nums = new int[]{2,0,2,1,1,0};
        q.sort(nums, 0, nums.length-1);
        for(int num: nums){
            System.out.println(num);
        }
    }
}