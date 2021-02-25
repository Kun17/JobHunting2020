/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        if (S.length() == 0) return "";
        int[] chs = new int[26];
        int max = 0;
        char letter = ' ';
        for (int i = 0; i < S.length(); i++) {
            chs[S.charAt(i) - 'a']++;
            if (chs[S.charAt(i) - 'a'] > max) {
                max = chs[S.charAt(i) - 'a'];
                letter = S.charAt(i);
            }
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        char[] ret = new char[S.length()];
        int idx = 0;
        while (chs[letter - 'a'] > 0) {
            ret[idx] = letter;
            idx += 2;
            if (idx >= S.length()) {
                idx = 1;
            }
            chs[letter - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            while (chs[i] > 0) {
                ret[idx] = (char) (i + 'a');
                chs[i]--;
                idx += 2;
                if (idx >= S.length()) {
                    idx = 1;
                }
            }
        }

        return new String(ret);
        
    }
}
// @lc code=end

