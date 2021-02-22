/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        for (int n: nums) {
            int idx = Math.abs(n) - 1;
            if (nums[idx] > 0) {
                nums[idx] = 0 - nums[idx];
            }
        }

        for (int n: nums) {
            int idx = Math.abs(n) - 1;
            nums[idx] = 0 - nums[idx];
        }

        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ret.add(i + 1);
            }
        }

        return ret;
    }
}
// @lc code=end

