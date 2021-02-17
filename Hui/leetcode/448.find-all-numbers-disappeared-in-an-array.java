/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num: nums) {
            int idx = Math.abs(num) % nums.length;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> ret = new ArrayList<Integer>();
        if (nums.length == 0) return ret;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i);
            }
        }

        if (nums[0] > 0) {
            ret.add(nums.length);
        }

        return ret;
    }
}
// @lc code=end

