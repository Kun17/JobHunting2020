/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 'a']++;
        }

        Stack<Character> stk = new Stack<Character>();
        int[] contain = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (contain[s.charAt(i) - 'a'] == 0) {
                while (stk.size() > 0 && stk.peek() > s.charAt(i) && chs[stk.peek() - 'a'] > 0) {
                    contain[stk.pop() - 'a'] = 0;
                }
                
                stk.push(s.charAt(i));
                contain[s.charAt(i) - 'a'] = 1;
            }
            
            chs[s.charAt(i) - 'a']--;
        }
        
        
        StringBuilder sb = new StringBuilder();
        while (stk.size() > 0) {
            sb.append(stk.pop());
        }
        
        return sb.reverse().toString();
    }
}
// @lc code=end

