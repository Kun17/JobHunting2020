/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();

        int max = 0;
        for (String word: words) {
            int len = 1;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                len = Math.max(len, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, len);
            max = Math.max(max, len);
        }

        return max;

        // Set<String> set = new HashSet<>();
        // Queue<String> queue = new LinkedList<>();
        // for (String word: words) {
        //     set.add(word);
        //     queue.add(word);
        // }

        // int dist = 0;
        // while (queue.size() > 0) {
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         String cur = queue.poll();
        //         List<String> nexts = getNexts(cur, set);
        //         for (String next: nexts) {
        //             queue.add(next);
        //         }
        //     }
        //     dist++;
        // }

        // return dist;
        
    }

    public List<String> getNexts(String word, Set<String> set) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i <= word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                String next = sb.substring(0, i) + (char) ('a' + j) + sb.substring(i);
                if (set.contains(next)) {
                    ret.add(next);
                }
            }
        }

        return ret;
    }
}
// @lc code=end

