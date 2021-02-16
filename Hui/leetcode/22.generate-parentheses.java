/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        helper(0, 0, n, new StringBuilder(), ret);
        return ret;
    }

    public void helper(int left, int right, int n, StringBuilder sb, List<String> ret) {
        if(left == n && right == n) {
            ret.add(new String(sb));
            return;
        }

        if(left > n || right > left) {
            return;
        } 

        sb.append('(');
        helper(left + 1, right, n, sb, ret);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        helper(left, right + 1, n, sb, ret);
        sb.deleteCharAt(sb.length() - 1);
    }
}
// @lc code=end

