/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        for (String str: tokens) {
            int a, b;
            switch(str) {
                case "+":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(a + b);
                    break;
                case "-":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(b - a);
                    break;
                case "*":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(a * b);
                    break;
                case "/":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(b / a);
                    break;
                default:
                    stk.push(Integer.parseInt(str));
            }
        }

        return stk.pop();
    }
}
// @lc code=end

