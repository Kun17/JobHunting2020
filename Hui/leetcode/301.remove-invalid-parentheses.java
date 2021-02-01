/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    /*
    Time: O(2 ^ N)
    Space: O(N)
    */
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else if(s.charAt(i) == ')') {
                left--;
            }
            if(left < 0) {
                left++;
                right++;
            }
        }

        Set<String> set = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        helper(s, s.length() - left - right, 0, 0, 0, left, right, sb, set);
        
        List<String> ret = new ArrayList<String>();
        for(String str: set) {
            ret.add(str);
        }
        return ret;
    }

    public void helper(String s, int len, int cur, int left, int right, int rmLeft, int rmRight, StringBuilder sb, Set<String> ret) {
        // System.out.println(cur + " " + sb.length() + " " + rmLeft + " " + rmRight);
        if(sb.length() == len && rmLeft == 0 && rmRight == 0) {
            ret.add(new String(sb));
            return;
        }
        if(cur == s.length() || left < right || rmLeft < 0 || rmRight < 0) {
            return;
        }

        char ch = s.charAt(cur);
        if(ch == '(') {
            // remove
            helper(s, len, cur + 1, left, right, rmLeft - 1, rmRight, sb, ret);
            // not remove
            sb.append(ch);
            helper(s, len, cur + 1, left + 1, right, rmLeft, rmRight, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        } else if(ch == ')') {
            // remove
            helper(s, len, cur + 1, left, right, rmLeft, rmRight - 1, sb, ret);
            // not remove
            sb.append(ch);
            helper(s, len, cur + 1, left, right + 1, rmLeft, rmRight, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(ch);
            helper(s, len, cur + 1, left, right, rmLeft, rmRight, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
// @lc code=end

