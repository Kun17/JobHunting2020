/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--) {
            isPal[i][i] = true;
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j == i + 1 || isPal[i + 1][j - 1]) {
                    isPal[i][j] = true;
                    }
                }
            }
        }

        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> subRet = new ArrayList<String>();
        helper(s, 0, isPal, subRet, ret);
        return ret;
    }

    public void helper(String s, int cur, boolean[][] isPal, List<String> subRet, List<List<String>> ret) {
        if(cur == s.length()) {
            ret.add(new ArrayList<String>(subRet));
            return;
        }

        for(int end = cur; end < s.length(); end++) {
            if(isPal[cur][end]) {
                subRet.add(s.substring(cur, end + 1));
                helper(s, end + 1, isPal, subRet, ret);
                subRet.remove(subRet.size() - 1);
            }
        }
    }
}
// @lc code=end

