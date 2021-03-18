/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0) return 0;
        // long[] mul = new long[nums.length];
        // mul[0] = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     mul[i] = nums[i] * mul[i - 1];
        // }

        int j = 0;
        int ret = 0;
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            tmp *= nums[i];

            while (j <= i && tmp >= k) {
                tmp = tmp / nums[j++];
            }
            ret += i - j + 1;
        }

        return ret;
    }
    //[10,9,10,4,3,8,3,3,6,2,10,10,9,3]\n19
}
// @lc code=end

