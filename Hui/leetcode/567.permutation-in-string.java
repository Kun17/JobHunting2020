/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] chs = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chs[s1.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            chs[s2.charAt(i) - 'a']--;
            if (chs[s2.charAt(i) - 'a'] >= 0) {
                count++;
            }
        }

        if (count == s1.length()) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            chs[s2.charAt(i - s1.length()) - 'a']++;
            if (chs[s2.charAt(i - s1.length()) - 'a'] > 0) {
                count--;
            }
            chs[s2.charAt(i) - 'a']--;
            if (chs[s2.charAt(i) - 'a'] >= 0) {
                count++;
            }

            if (count == s1.length()) return true;
        }

        return false;
    }
}
// @lc code=end

