/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (next < 2 || nums[next - 2] != nums[i]) {
                nums[next] = nums[i];
                next++;
            }
        }

        return next;
    }
}
// @lc code=end

