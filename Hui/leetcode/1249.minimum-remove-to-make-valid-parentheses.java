/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        Set<Integer> remove = new HashSet<Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i);
            } else if(s.charAt(i) == ')') {
                if(stk.size() > 0) {
                    stk.pop();
                } else {
                    remove.add(i);
                }
            }
        }

        while(stk.size() > 0) {
            remove.add(stk.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!remove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return new String(sb);
    }
}
// @lc code=end
