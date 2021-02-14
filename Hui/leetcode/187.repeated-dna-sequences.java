/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> first = new HashSet<String>();
        Set<String> second = new HashSet<String>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String substr = s.substring(i, i + 10);
            if (first.contains(substr)) {
                first.remove(substr);
                second.add(substr);
            } else if (!second.contains(substr)) {
                first.add(substr);
            }
        }

        List<String> ret = new ArrayList<String>(second);
        return ret;
    }
}
// @lc code=end

