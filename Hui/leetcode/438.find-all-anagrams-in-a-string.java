/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(i, 0) + 1);
        }

        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        int si = 0;
        int remain = p.length();
        List<Integer> ret = new ArrayList<Integer>();
        for (int ei = 0; ei < s.length(); ei++) {
            if (!map.containsKey(s.charAt(ei))) {
                while (si <= ei) {
                    char remove = s.charAt(si);
                    if (map.containsKey(remove)) {
                        count[remove - 'a']++;
                        remain++;
                    }
                    si++;
                }
                // System.out.println("ei=" + ei + " si=" + si);
            } else if (count[s.charAt(ei) - 'a'] == 0) {
                while (s.charAt(si) != s.charAt(ei)) {
                    remain++;
                    count[s.charAt(si) - 'a']++;
                    si++;
                }
                si++;
            } else {
                count[s.charAt(ei) - 'a']--;
                remain--;
            }

            if (remain == 0) {
                ret.add(si);
            }
        }

        return ret;
    }
}
// @lc code=end

