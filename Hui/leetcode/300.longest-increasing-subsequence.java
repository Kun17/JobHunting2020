/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] len = new int[nums.length + 1];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[0] = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            // find the first smaller
            int si = 0, ei = i + 1;
            while (si < ei) {
                int mid = si + (ei - si) / 2;
                if (len[mid] < target) {
                    si = mid + 1;
                } else {
                    ei = mid;
                }
            }

            len[si] = Math.min(nums[i], len[si]);
        }

        for (int i = 0; i < len.length; i++) {
            // System.out.println(len[i]);
            if (len[i] == Integer.MAX_VALUE) {
                return i - 1;
            }
        }

        return nums.length;
    }
}
// @lc code=end

