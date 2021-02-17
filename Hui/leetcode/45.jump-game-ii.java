/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        Queue<Integer> queue = new LinkedList<Integer>();
        // Set<Integer> visited = new HashSet<Integer>();
        queue.add(0);
        // visited.add(0);
        int step = 0;
        int max = 0;
        while (max < nums.length - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next = cur + nums[cur]; next > max; next--) {
                    queue.add(next);
                    // visited.add(next);
                }
                max = Math.max(max, cur + nums[cur]);
            }
            step++;
        }

        return step;
    }
}
// @lc code=end

