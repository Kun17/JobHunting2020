/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    public void helper(int[] nums, int cur, List<Integer> tmp, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(tmp));
        for(int i = cur; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(nums, i + 1, tmp, ret);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end

