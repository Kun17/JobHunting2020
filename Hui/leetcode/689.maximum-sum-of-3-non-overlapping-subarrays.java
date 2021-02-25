/*
 * @lc app=leetcode id=689 lang=java
 *
 * [689] Maximum Sum of 3 Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        int[] sums = new int[nums.length];
        int[] max = new int[nums.length];
        max[k - 1] = k - 1;
        sums[k - 1] = sum;
        for (int i = k; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i] - nums[i - k];
            if (sums[i] > sums[max[i - 1]]) {
                max[i] = i;
            } else {
                max[i] = max[i - 1];
            }
        }

        int[][] max2 = new int[nums.length][2]; 
        max2[2 * k - 1] = new int[]{k - 1, 2 * k - 1};
        for (int i = 2 * k; i < nums.length; i++) {
            if (sums[i] + sums[max[i - k]] > sums[max2[i - 1][0]] + sums[max2[i - 1][1]]) {
                max2[i] = new int[]{max[i - k], i};
            } else {
                max2[i] = new int[]{max2[i - 1][0], max2[i - 1][1]};
            }
        }

        int max3 = 0;
        int[] ret = new int[3];
        for (int i = 3 * k - 1; i < nums.length; i++) {
            if (sums[i] + sums[max2[i - k][0]] + sums[max2[i - k][1]] > max3) {
                max3 = sums[i] + sums[max2[i - k][0]] + sums[max2[i - k][1]];
                ret = new int[]{max2[i - k][0] - k + 1, max2[i - k][1] - k + 1, i - k + 1};
            }
        }
        return ret;
    }
    // [4,5,10,6,11,17,4,11,1,3]\n1
}
// @lc code=end

