/*
 * @lc app=leetcode id=736 lang=java
 *
 * [736] Parse Lisp Expression
 */

// @lc code=start
class Solution {
    int idx = 0;
    Map<String, Integer> map = new HashMap<>();

    public int evaluate(String expression) {
        char operator = ' ';
        String variable = "";
        int num = 0;
        while (idx < expression.length()) {
            if (expression.charAt(idx) == '(') {
                idx++;
                return evaluate(expression);
            }

            if (expression.substring(idx, idx + 4).equals("let ")) {
                operator = '=';
                idx = idx + 4;
            } else if (expression.substring(idx, idx + 5).equals("mult ")) {
                operator = '*';
                idx = idx + 5;
            } else if (expression.substring(idx, idx + 4).equals("add ")) {
                operator = '+';
                idx = idx + 4;
            } else if (expression.charAt(idx) == ')') {
                if (operator.equals('=')) {
                    if (variable.equals("")) {
                        return num1;
                    } else {
                        return map.get(variable);
                    }
                } else if (operator.equals('+')) {
                    return num1 + num2;
                }
            } else if (expression.charAt(idx) == '(') {
                idx++;
                num1 = evaluate(expression);
            } else if (expression.charAt(idx) != ' ') {
                int cur = idx;
                while (expression.charAt(cur) != ' ' && expression.charAt(cur) != ')') {
                    cur++;
                }
                String str = expressioin.substring(idx, cur);
                if (str.mathces("\\d+")) {
                    map.put(variable, Integer.parseInt(str));
                } else {
                    variable = str;
                }
                idx = cur;
            }

        }
        return helper(strs);
    }
}
// @lc code=end

