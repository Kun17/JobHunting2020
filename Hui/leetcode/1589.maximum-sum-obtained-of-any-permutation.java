/*
 * @lc app=leetcode id=1589 lang=java
 *
 * [1589] Maximum Sum Obtained of Any Permutation
 */

// @lc code=start
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] count = new int[nums.length];
        for (int[] r: requests) {
            count[r[0]] += 1;
            if (r[1] + 1 < nums.length) {
                count[r[1] + 1] -= 1;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            count[i] += count[i - 1];
        }
        Arrays.sort(count);
        Arrays.sort(nums);

        long ret = 0;
        long MOD = (long)1e9 + 7;
        for (int i = nums.length - 1; i >= 0 && count[i] > 0; i--) {
            ret = (ret + (long) nums[i] * (long) count[i]) % MOD;
        }

        return (int) ret;
    }
}
// @lc code=end

