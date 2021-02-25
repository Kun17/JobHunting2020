/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;

        boolean cap = isCap(word.charAt(word.length() - 1));

        for (int i = word.length() - 2; i > 0; i--) {
            if (!isCap(word.charAt(i)) && cap) return false;
            if (isCap(word.charAt(i)) && !cap) return false;
        }

        if (!isCap(word.charAt(0)) && cap) return false;
        return true;
    }

    public boolean isCap (char c) {
        return 'A' <= c && c <= 'Z';
    }
}
// @lc code=end

