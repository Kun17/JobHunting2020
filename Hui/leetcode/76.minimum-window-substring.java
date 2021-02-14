/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            dictionary.put(t.charAt(i), dictionary.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0; 
        int r = 0;
        int remain = t.length();
        int startIdx = -1;
        int min = Integer.MAX_VALUE;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (dictionary.containsKey(ch)) {
                dictionary.put(ch, dictionary.get(ch) - 1);
                if (dictionary.get(ch) >= 0) {
                    remain--;
                }
                while (remain == 0) {
                    if (r - l + 1 < min) {
                        startIdx = l;
                        min = r - l + 1;
                    }
                    if (dictionary.containsKey(s.charAt(l))) {
                        dictionary.put(s.charAt(l), dictionary.get(s.charAt(l)) + 1);
                        if (dictionary.get(s.charAt(l)) > 0) {
                            remain++;
                        }
                    }
                    l++;
                }
            }
            r++;
            // System.out.println(r + " " + min);
        }
        if (startIdx == -1) {
            return "";
        }
        return s.substring(startIdx, startIdx + min);
    }
    //""a"\n"a""
}
// @lc code=end

