/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<Integer>();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (last[c - 'a'] == -1) {
                last[c - 'a'] = i;
            }
        }
        
        int si = 0;
        int far = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i > far) {
                ret.add(i - si);
                si = i;
            }
            far = Math.max(far, last[S.charAt(i) - 'a']);
        }

        ret.add(S.length() - si);
        return ret;
    }
}
// @lc code=end

