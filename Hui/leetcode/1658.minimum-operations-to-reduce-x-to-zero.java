/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);

        int cur = 0;
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (!sumMap.containsKey(cur)) {
                sumMap.put(cur, i);
            }
            int target = x - (sum - cur);
            if (sumMap.containsKey(target)) {
                ret = Math.min(ret, nums.length - (i - sumMap.get(target)));
            }
        }
        if (ret == Integer.MAX_VALUE) return -1;
        return ret;
    }
}
// @lc code=end

