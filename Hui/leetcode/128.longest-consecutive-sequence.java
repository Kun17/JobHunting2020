/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> numLen = new HashMap<Integer, Integer>();
        for (int num: nums) {
            if (numLen.containsKey(num)) continue;

            int len = numLen.getOrDefault(num - 1, 0) + numLen.getOrDefault(num + 1, 0) + 1;
            numLen.put(num, len);
            if (numLen.containsKey(num - 1)) {
                numLen.put(num - numLen.get(num - 1), len);
            }
            if (numLen.containsKey(num + 1)) {
                numLen.put(num + numLen.get(num + 1), len);
            }

            max = Math.max(max, len);
        }

        return max;
    }
}
// @lc code=end

