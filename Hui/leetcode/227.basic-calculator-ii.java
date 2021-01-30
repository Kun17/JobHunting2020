/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int num = 0;
        char operator = '+';

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + (int) (ch - '0');
            }
            if (i == s.length() - 1 || isOperator(ch)) {
                switch(operator){
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(num * -1);
                        break;
                    case '*':
                        stk.push(stk.pop() * num);
                        break;
                    default:
                        stk.push(stk.pop() / num);
                        break;
                }
                operator = ch;
                num = 0;
            }
        }

        int ret = 0;
        while(stk.size() > 0) {
            ret += stk.pop();
        }

        return ret;
    }

    public boolean isOperator(char ch) {
        return ch == '-' || ch == '+' || ch == '*' || ch =='/';
    }
}
// @lc code=end

