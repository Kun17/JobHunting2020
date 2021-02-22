/*
 * @lc app=leetcode id=436 lang=java
 *
 * [436] Find Right Interval
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals[i][0], i);
        }

        Arrays.sort(arr, (a, b) -> a.s - b.s);

        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            ret[i] = findGreater(arr, target);
        }

        return ret;
    }

    public int findGreater(Interval[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid].s < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (nums[s].s < target) return -1;
        return nums[s].i;
    }

    class Interval {
        int s, i;
        public Interval(int s, int idx) {
            this.s = s;
            this.i = idx;
        }
    }
}
// @lc code=end

