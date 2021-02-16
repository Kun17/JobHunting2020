/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    /* 
    Time: O(k C(n, k)) C(n, k) combinations, and cost k to append each sub result to ret
    Space: O(C(n, k))
    */ 
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        helper(n, 1, k, temp, ret);
        return ret;
    }

    public void helper(int n, int cur, int k, List<Integer> temp, List<List<Integer>> ret) {
        if (temp.size() == k) {
            ret.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = cur; i <= n; i++) {
            temp.add(i);
            helper(n, i + 1, k, temp, ret);
            temp.remove(temp.size() - 1);
        }
    }
}
// @lc code=end

