/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 */

// @lc code=start
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, List<Integer>> begin = new HashMap<>();
        Map<String, List<Integer>> end = new HashMap<>();
        Map<String, List<Integer>> set = new HashMap<>();

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0 ; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            String wordReverse = sb.reverse().toString();
            for (int j = 0; j <= words[i].length(); j++) {
                if (palindrome(words[i], 0, j - 1)) {
                    List<Integer> list = end.getOrDefault(words[i].substring(j), new ArrayList<>());
                    list.add(i);
                    end.put(words[i].substring(j), list);
                }
            }
            for (int j = words[i].length(); j >= 0; j--) {
                if (palindrome(words[i], j, words[i].length() - 1)) {
                    List<Integer> list = begin.getOrDefault(words[i].substring(0, j), new ArrayList<>());
                    list.add(i);
                    begin.put(words[i].substring(0, j), list);
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            String reverse = sb.reverse().toString();
            if (end.containsKey(reverse)) {
                for (int index: end.get(reverse)) {
                    if (index != i)
                        ret.add(new ArrayList<>(Arrays.asList(i, index)));
                }
            }

            if (begin.containsKey(reverse)) {
                for (int index: begin.get(reverse)) {
                    if (words[i].length() != words[index].length())
                        ret.add(new ArrayList<>(Arrays.asList(index, i)));
                }
            }
        }

        return ret;
    }

    public boolean palindrome(String s, int si, int ei) {
        while (si < ei) {
            if (s.charAt(si) != s.charAt(ei)) {
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }
    // ["a",""]
}
// @lc code=end

