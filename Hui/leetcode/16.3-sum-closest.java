/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
/*
    Using closest only may cause overflow. Remember to keep both minDiff and closest variable.
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closest = 0;
        Arrays.sort(nums);
        for(int k = 0; k < nums.length - 2; k++) {
            if(k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while(i < j) {
                if(i > k + 1 && nums[i] == nums[i-1]) {
                    i++;
                    continue;
                }
                if(j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                int sum = nums[k] + nums[i] + nums[j];
                if(Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    closest = sum;
                } else if(sum == target) {
                    return target;
                }
                if(sum <= target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return closest;
    }
}
// @lc code=end

