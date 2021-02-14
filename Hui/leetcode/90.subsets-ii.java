/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    public void dfs(int[] nums, int pos, List<Integer> subset, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(subset));

        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, ret);
            subset.remove(subset.size() - 1);
        }

    }
}
// @lc code=end

