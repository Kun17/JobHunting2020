/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        // bucket sort
        // exclude min/max, should have n - 1 buckets to ensure at least 1 bucket is empty
        // where is also the max gap we are looking for
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int n = nums.length;
        int interval = (int) Math.ceil((double) (max - min) / (n - 1));
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);

        for (int num: nums) {
            if (num == min || num == max) continue;
            int bucket = (num - min) / interval;
            bucketMin[bucket] = Math.min(bucketMin[bucket], num);
            bucketMax[bucket] = Math.max(bucketMax[bucket], num);
        }

        int prevMax = min;
        int maxGap = 0;
        for (int i = 0; i < n - 1; i++) {
            if (bucketMax[i] == -1) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        maxGap = Math.max(maxGap, max - prevMax);
        return maxGap;
    }
}
// @lc code=end

