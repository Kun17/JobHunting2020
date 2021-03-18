/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tree = new TreeMap<>((a, b) -> a - b);

        int i = 0, j = 0;
        int ret = 0;
        while (j < nums.length) {
            tree.put(nums[j], tree.getOrDefault(nums[j], 0) + 1);
            int min = tree.firstKey();
            int max = tree.lastKey();
            while (max - min > limit) {
                int delete = nums[i];
                if (tree.get(nums[i]) == 1) {
                    tree.remove(nums[i]);
                } else {
                    tree.put(nums[i], tree.get(nums[i]) - 1);
                }
                max = tree.lastKey();
                min  = tree.firstKey();
                i++;
            }
            ret = Math.max(ret, j - i + 1);
            j++;
        }

        return ret;
    }
}
// @lc code=end

