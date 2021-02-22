/*
 * @lc app=leetcode id=1235 lang=java
 *
 * [1235] Maximum Profit in Job Scheduling
 */

// @lc code=start
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        if (n == 0) return 0;
        Interval[] ins = new Interval[n + 1];
        ins[0] = new Interval(0, 0, 0);
        for (int i = 0; i < n; i++) {
            ins[i + 1] = new Interval(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(ins, (a, b) -> a.e - b.e);

        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int target = ins[i].s;
            int index = findFirstLessOrEqual(ins, i - 1, target);
            dp[i] = Math.max(max, dp[index] + ins[i].p);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int findFirstLessOrEqual(Interval[] ins, int end, int target) {
        int s = 0, e = end;
        while (e - s > 1) {
            int mid = s + (e - s) / 2;
            if (ins[mid].e > target) {
                e = mid;
            } else {
                s = mid;
            }
        }

        if (ins[e].e <= target) {
            return e;
        }

        return s;
    }

    class Interval {
        int s, e;
        int p;
        public Interval(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
}
// @lc code=end

