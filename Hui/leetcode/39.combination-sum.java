/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(candidates, 0, 0, target, new ArrayList<Integer>(), ret);
        return ret;  
    }

    public void helper(int[] nums, int pos, int sum, int target, List<Integer> tmp, List<List<Integer>> ret) {
        if(sum == target) {
            ret.add(new ArrayList<Integer>(tmp));
        }
        if(sum > target) {
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            if(sum + nums[i] >  target) {
                break;
            }
            tmp.add(nums[i]);
            helper(nums, i, sum + nums[i], target, tmp, ret);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end

