/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(candidates, 0, 0, target, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    public void helper(int[] nums, int pos, int sum, int target, List<Integer> tmp, List<List<Integer>> ret) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }

        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            if(sum + nums[i] >  target) {
                break;
            }
            tmp.add(nums[i]);
            helper(nums, i + 1, sum + nums[i], target, tmp, ret);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end

