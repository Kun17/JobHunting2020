/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                // System.out.println(ch);
                stk.push(ch);
            } else {
                char valid = ' ';
                switch(ch) {
                    case ')':
                        valid = '(';
                        break;
                    case ']':
                        valid = '[';
                        break;
                    default:
                        valid = '{';
                        break;
                }
                if(stk.isEmpty() || stk.peek() != valid) {
                    return false;
                } else {
                    stk.pop();
                }
            }
        }

        return stk.isEmpty();
    }
}
// @lc code=end

