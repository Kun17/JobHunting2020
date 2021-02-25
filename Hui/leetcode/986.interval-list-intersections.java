/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;

        int end = Integer.MIN_VALUE;
        while (i < firstList.length && j < secondList.length) {
            int[] cur;
            if (firstList[i][0] < secondList[j][0]) {
                cur = firstList[i];
                i++;
            } else {
                cur = secondList[j];
                j++;
            }
            if (cur[0] <= end) {
                list.add(new int[]{cur[0], Math.min(end, cur[1])});
            }

            end = Math.max(end, cur[1]);
        }
        while (j < secondList.length && secondList[j][0] <= end) {
            list.add(new int[]{secondList[j][0], Math.min(end, secondList[j][1])});
            end = Math.max(end, secondList[j][1]);
            j++;
        }

        while (i < firstList.length && firstList[i][0] <= end) {
            list.add(new int[]{firstList[i][0], Math.min(end, firstList[i][1])});
            end = Math.max(end, firstList[i][1]);
            i++;
        }

        int[][] ret = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            ret[k] = list.get(k);
        }

        return ret;
    }
}
// @lc code=end

