/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int sign = 1;
        int num = 0;
        int ret = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + (int) (ch - '0');
            } else if(ch == '+' || ch =='-') {
                ret += sign * num;
                if(ch == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
                num = 0;
            } else if(ch == '(') {
                stk.push(ret);
                stk.push(sign);
                ret = 0;
                sign = 1;
            } else if(ch == ')') {
                ret += sign * num;
                ret *= stk.pop();
                ret += stk.pop();
                num = 0;
            }
        }

        return ret + sign * num;
    }
    /* 
    int idx = 0;
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int sign = 1;
        int num = 0;
        while(idx < s.length()) {
            char ch = s.charAt(idx);
            if(isOperator(ch)) {
                stk.push(sign * num);
                num = 0;
                if(ch == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
                idx++;
            } else if(isDigit(ch)) {
                num *= 10;
                num += (int) (ch - '0');
                idx++;
            } else if(ch == '(') {
                idx++;
                num = calculate(s);
                idx++;
            } else if(ch == ')') {
                stk.push(sign * num);
                int ret = 0;
                while(stk.size() > 0) {
                    ret += stk.pop();
                }
                return ret;
            } else {
                idx++;
            }

            if(idx == s.length()) {
                stk.push(sign * num);
            }
        }

        int ret = 0;
        while(stk.size() > 0) {
            // System.out.println(stk.peek());
            ret += stk.pop();
        }
        return ret;
    }

    public boolean isOperator(char ch) {
        return ch == '+' || ch == '-';
    }

    public boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    */
}
// @lc code=end

