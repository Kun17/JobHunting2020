/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int longest = 0;
        int end = Integer.MIN_VALUE;
        for (int[] i: intervals) {
            if (end <= i[0]) {
                longest++;
                end = i[1];
            }
        }

        return intervals.length - longest;
    }
}
// @lc code=end

