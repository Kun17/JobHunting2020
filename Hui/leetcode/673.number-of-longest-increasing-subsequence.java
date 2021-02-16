/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxLenCnt = 0, maxLen = 0;
        int[] len = new int[nums.length];
        int[] cnt = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] >= nums[i]) {
                    continue;
                }
                if(len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];
                } else if(len[j] + 1 == len[i]) {
                    cnt[i] += cnt[j];
                }
            }
            if(len[i] > maxLen) {
                maxLen = len[i];
                maxLenCnt = cnt[i];
            } else if(len[i] == maxLen) {
                maxLenCnt += cnt[i];
            }
        }

        return maxLenCnt;
    }
}
// @lc code=end

