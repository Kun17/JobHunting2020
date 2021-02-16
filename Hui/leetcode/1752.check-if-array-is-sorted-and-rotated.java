class Solution {
    public boolean check(int[] nums) {
        boolean flip = false;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] && flip) {
                return false;
            } else if (nums[i] < nums[i - 1] && !flip) {
                flip = true;
            }
        }
        if (flip) {
            return nums[nums.length - 1] <= nums[0];
        }
        return true;
    }
}
