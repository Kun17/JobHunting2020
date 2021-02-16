/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(nums, 0,  new boolean[nums.length], new ArrayList<Integer>(), ret);
        return ret;
    }

    public void helper(int[] nums, int pos, boolean[] seen, List<Integer> tmp, List<List<Integer>> ret) {
        if(tmp.size() == nums.length) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !seen[i-1]) {
                continue;
            }
            if(seen[i]) {
                continue;
            }
            seen[i] = true;
            tmp.add(nums[i]);
            helper(nums, 0, seen, tmp, ret);
            tmp.remove(tmp.size() - 1);
            seen[i] = false;
        }
    }
}
// @lc code=end

