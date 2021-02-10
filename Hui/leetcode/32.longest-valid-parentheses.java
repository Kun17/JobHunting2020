/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                if (stk.size() > 0 && s.charAt(stk.peek())  == '(') {
                    stk.pop();
                    if (stk.size() == 0) {
                        max = Math.max(max, i + 1);
                    } else {
                        max = Math.max(max, i - stk.peek());
                    }
                } else {
                    stk.push(i);
                }
            }
        }

        return max;
    }
}
// @lc code=end

