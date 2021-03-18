/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(k, 1, 0, n, tmp, ret);
        return ret;
    }

    public void helper(int k, int pos, int sum, int target, List<Integer> tmp, List<List<Integer>> ret) {
        if (sum == target && k == 0) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        if (k < 0 || sum > target || pos >= 10) {
            return;
        }
        
        helper(k, pos + 1, sum, target, tmp, ret);

        tmp.add(pos);
        helper(k - 1, pos + 1, sum + pos, target, tmp, ret);
        tmp.remove(tmp.size() - 1);
    }
}
// @lc code=end

