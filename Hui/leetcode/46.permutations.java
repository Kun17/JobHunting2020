/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), ret);
        return ret;
    }

    public void helper(int[] nums, boolean[] seen, List<Integer> tmp, List<List<Integer>> ret) {
        if(tmp.size() == nums.length) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(seen[i]) {
                continue;
            }
            seen[i] = true;
            tmp.add(nums[i]);
            helper(nums, seen, tmp, ret);
            tmp.remove(tmp.size() - 1);
            seen[i] = false;
        }
    }
}
// @lc code=end

