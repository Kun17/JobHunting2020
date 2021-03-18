/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses];
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < numCourses; i++) lists[i] = new ArrayList<>();
        for (int[] p: prerequisites) {
            pre[p[0]]++;
            lists[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pre[i] == 0) {
                queue.add(i);
            }
        }
        
        int take = 0;
        while (queue.size() > 0) {
            int cur = queue.poll();
            take++;
            for (int next: lists[cur]) {
                pre[next]--;
                if (pre[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return take == numCourses;
    }
}
// @lc code=end

