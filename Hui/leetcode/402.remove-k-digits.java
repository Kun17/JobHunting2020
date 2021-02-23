/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            while (stk.size() > 0 && stk.peek() > num.charAt(i) && count < k) {
                count++;
                stk.pop();
            }
            stk.push(num.charAt(i));
        }
        while (count < k && stk.size() > 0) {
            count++;
            stk.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (stk.size() > 0) {
            sb.append(stk.pop());
        }
        sb = sb.reverse();
        int first = 0;
        while (first < sb.length() && sb.charAt(first) == '0') {
            first++;
        }
        if (first == sb.length()) return "0";
        return sb.substring(first);
    }
}
// @lc code=end

