/*
 * @lc app=leetcode id=828 lang=java
 *
 * [828] Count Unique Characters of All Substrings of a Given String
 */

// @lc code=start
class Solution {
    public int uniqueLetterString(String s) {
        // count how many points can cur character contribute to total points
        // depend on where is previous and next occurrence
        // within this range, every substring containing cur character would count it as 1 point
        // thus, this question can be transferred to the question
        // how many substrings are there that containing this cur character between (i, j)
        // where i, j is the prevsiou and next occurrence

        int[][] map = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(map[i], -1);
        }

        long ret = 0;
        int MOD = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            int len1 = map[s.charAt(i) - 'A'][1] - map[s.charAt(i) - 'A'][0];
            int len2 = i - map[s.charAt(i) - 'A'][1];
            ret = (ret + (len1 * len2) % MOD) % MOD;
            map[s.charAt(i) - 'A'] = new int[]{map[s.charAt(i) - 'A'][1], i};
        }

        for (int i = 0; i < 26; i++) {
            int len1 = map[i][1] - map[i][0];
            int len2 = s.length() - map[i][1];
            ret = (ret + (len1 * len2) % MOD) % MOD;
        }

        return (int) ret;
        // int n = s.length();
        // long ret = 0;
        // int MOD = 1000000007;
        // for (int i = 0; i < n; i++) {
        //     int[] dp = new int[n];
        //     // System.out.println();
        //     // System.out.println(i + " -------- ");
        //     Set<Character> set = new HashSet<Character>();
        //     Set<Character> dup = new HashSet<Character>();
        //     for (int j = i; j < n; j++) {
        //         char c = s.charAt(j);
        //         if (set.contains(c)) {
        //             dup.add(c);
        //             dp[j] = set.size() - dup.size();
        //         } else if (j > i) {
        //                 dp[j] = dp[j - 1] + 1;
        //         } else {
        //             dp[j] = 1;
        //         }
        //         // System.out.print(dp[j] + " ");
        //         // System.out.println();
        //         set.add(c);
        //         ret = (ret + dp[j] % MOD) % MOD;
        //     }
        // }

        // return (int) ret;
    } 
    // ""ABA""
}
// @lc code=end

