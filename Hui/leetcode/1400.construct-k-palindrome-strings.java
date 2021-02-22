/*
 * @lc app=leetcode id=1400 lang=java
 *
 * [1400] Construct K Palindrome Strings
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String s, int k) {
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 'a']++;
        }

        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (chs[i] % 2 == 1) {
                odd++;
            }
        }

        return odd <= k && s.length() >= k;
    }
}
// @lc code=end

