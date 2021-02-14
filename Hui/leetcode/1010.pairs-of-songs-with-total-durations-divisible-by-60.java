/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> mod = new HashMap<Integer, Integer>();
        
        for (int t: time) {
            int count = mod.getOrDefault(t % 60, 0);
            mod.put(t % 60, count + 1);
        }
        // System.out.println(mod);
        int ret = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int m: mod.keySet()) {
            if(set.contains(m) || set.contains(60 - m)) {
                continue;
            }
            int count1 = mod.get(m);
            if(m == 0 || m == 30) {
                ret += count1 * (count1 - 1) / 2;
                // System.out.println("1 = " + count1 * (count1 - 1) / 2);
            } else {
                int count2 = mod.getOrDefault(60 - m, 0);
                ret += count1 * count2;
                // System.out.println("2 = " + count1 * count2);
                set.add(60 - m);
            }
            set.add(m);
        }

        return ret;
    }
}
// @lc code=end

