/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<int[]>();

        list.add(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});

        for(int[] in: intervals) {
            if (in[0] <= list.get(list.size() - 1)[1]) {
                int curEnd = list.get(list.size() - 1)[1];
                list.get(list.size() - 1)[1] = Math.max(curEnd, in[1]);
            } else {
                list.add(in);
            }
        }

        int[][] ret = new int[list.size() - 1][2];
        for(int i = 1; i < list.size(); i++) {
            ret[i - 1] = list.get(i);
        }

        return ret;
    }
}
// @lc code=end

