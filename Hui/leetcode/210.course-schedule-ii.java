/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses];
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < numCourses; i++) lists[i] = new ArrayList<>();

        for (int[] p: prerequisites) {
            pre[p[0]]++;
            lists[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] ret = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (pre[i] == 0) {
                queue.add(i);
            }
        }
        int taken = 0;
        while (queue.size() > 0) {
            int cur = queue.poll();
            ret[taken++] = cur;
            for (int next: lists[cur]) {
                pre[next]--;
                if (pre[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (taken < numCourses) return new int[]{};
        return ret;
    }

}
// @lc code=end

