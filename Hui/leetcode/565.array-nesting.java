/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int ret = 1;
        int[] visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                ret = Math.max(ret, helper(nums, i, visited, 0));
            }
        }

        return ret;
    }

    public int helper(int[] nums, int cur, int[] visited, int l) {
        if (visited[cur] == 1) {
            return l;
        }

        visited[cur] = 1;
        return helper(nums, nums[cur], visited, l + 1);
    }
}
// @lc code=end

