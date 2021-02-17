/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < T.length; i++) {
            while (stk.size() > 0 && T[stk.peek()] < T[i]) {
                int j = stk.pop();
                ret[j] = i - j;
            }
            stk.push(i);
        }

        return ret;
    }
}
// @lc code=end

