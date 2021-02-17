/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strs) {
            int[] chs = new int[26];
            for (int i = 0; i < s.length(); i++) {
                chs[s.charAt(i) - 'a']++;
            }
            String key = "";
            for (int i = 0; i < 26; i++) {
                key += chs[i] + ",";
            }
            // System.out.println(key);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);

            map.put(key, list);
        }

        List<List<String>> ret = new ArrayList<List<String>>();
        for (List<String> list: map.values()) {
            ret.add(list);
        }

        return ret;
    }
}
// @lc code=end

