/*
 * @lc app=leetcode id=1673 lang=java
 *
 * [1673] Find the Most Competitive Subsequence
 */

// @lc code=start
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (stk.size() > 0 && stk.peek() > nums[i] && stk.size() - 1 + nums.length - i >= k) {
                stk.pop();
            }
            if (stk.size() < k) {
                stk.push(nums[i]);
            }
        }
        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ret[i] = stk.pop();
        }

        return ret;
    }
}
// @lc code=end

