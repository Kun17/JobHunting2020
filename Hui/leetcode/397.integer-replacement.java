/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 */

// @lc code=start
class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n == Integer.MAX_VALUE) return 32;
        Map<Integer, Integer> memo = new HashMap<>();
        helper(n, memo);
        return memo.get(n);
    }

    public int helper(int n, Map<Integer, Integer> memo) {
        if (n == 1) return 0;

        if (memo.containsKey(n)) return memo.get(n);

        int ret = 0;
        if (n % 2 == 0) {
            ret = helper(n / 2, memo) + 1;
        } else {
            ret = Math.min(helper(n - 1, memo), helper(n + 1, memo)) + 1;
        }

        memo.put(n, ret);
        return ret;
    }
}
// @lc code=end

