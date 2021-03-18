/*
 * @lc app=leetcode id=1297 lang=java
 *
 * [1297] Maximum Number of Occurrences of a Substring
 */

// @lc code=start
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> count = new HashMap<>();
        int[] chs = new int[26];
        int unique = 0;
        for (int i = 0; i < minSize; i++) {
            if (chs[s.charAt(i) - 'a'] == 0) {
                unique += 1;
            }
            chs[s.charAt(i) - 'a'] += 1;
        }

        if (unique <= maxLetters) {
            count.put(s.substring(0, minSize), 1);
        }

        for (int j = minSize; j < s.length(); j++) {
            if (chs[s.charAt(j - minSize) - 'a'] == 1) {
                unique -= 1;
            }
            chs[s.charAt(j - minSize) - 'a'] -= 1;
            if (chs[s.charAt(j) - 'a'] == 0) {
                unique += 1;
            }
            chs[s.charAt(j) - 'a'] += 1;
            String sub = s.substring(j - minSize + 1, j + 1);
            if (unique <= maxLetters) {
                count.put(sub, count.getOrDefault(sub, 0) + 1);
            }
        }
        // System.out.println(count);
        int ret = 0;
        for (String key: count.keySet()) {
            ret = Math.max(ret, count.get(key));
        }
        return ret;
    }
}
// @lc code=end

