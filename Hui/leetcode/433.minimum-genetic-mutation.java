/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s: bank) {
            set.add(s);
        }
        if (!set.contains(end)) return -1;
        List<Character> chs = new ArrayList<>(Arrays.asList('A', 'C', 'G', 'T'));
        Queue<String> q = new LinkedList<>();
        q.add(start);

        int dist = 0;
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curStr = q.poll();
                if (curStr.equals(end)) {
                    return dist;
                }
                char[] curArray = curStr.toCharArray();
                for (int j = 0; j < curArray.length; j++) {
                    char charOld = curArray[j];
                    for (char c: chs){
                        curArray[j] = c;
                        String next = new String(curArray);
                        // System.out.println(next);
                        if (set.contains(next)) {
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    curArray[j] = charOld;
                }
            }
            dist++;
        }

        return -1;
    }
}
// @lc code=end

