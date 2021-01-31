/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        return match(s, p, 0, 0) == 1;
    }

    public int match(String s, String p, int si, int pi) {
        if(memo[si][pi] != 0) {
            return memo[si][pi];
        }

        memo[si][pi] = -1;
        if(pi == p.length()) {
            if(si == s.length()) {
                memo[si][pi] = 1;
            }
        } else {
            // first check whether at cur pos the character matches
            boolean firstMatch = false;
            if(si < s.length() && s.charAt(si) == p.charAt(pi)) {
                firstMatch = true;
            }
            if(si < s.length() && p.charAt(pi) == '.') {
                firstMatch = true;
            }

            // if followed by '*'
            // two cases need to be checked:
            // 1. if first matched, [si + 1, pi]
            // 2. whether or not first matched, [si, pi + 2];
            if(pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                if(firstMatch && match(s, p, si + 1, pi) == 1) {
                    memo[si][pi] = 1;
                }
                if(match(s, p, si, pi + 2) == 1) {
                    memo[si][pi] = 1;
                }
            } else if(firstMatch) {
                memo[si][pi] = match(s, p, si + 1, pi + 1);
            }
        }

        return memo[si][pi];
    }
    // int memo[][];
    // public boolean isMatch(String s, String p) {
    //     memo = new int[s.length() + 1][p.length() + 1];
    //     return isMatch(s, p, 0, 0) == 1;
    // }

    // public int isMatch(String s, String p, int si, int pi) {
    //     if(memo[si][pi] != 0) {
    //         return memo[si][pi];
    //     }
    //     if(si == s.length() || pi == p.length()) {
    //         if(si == s.length() && pi == p.length()) {
    //             memo[si][pi] = 1;
    //             return memo[si][pi];
    //         } else if(si == s.length() && pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
    //             int starPos = pi + 1;
    //             while(starPos < p.length()) {
    //                 if(p.charAt(starPos) != '*'){
    //                     memo[si][pi] = -1;
    //                     return memo[si][pi];
    //                 }
    //                 starPos += 2;
    //             }
    //             if(starPos == p.length() + 1) {
    //                 memo[si][pi] = 1;
    //             } else {
    //                 memo[si][pi] = -1;
    //             }
    //             return memo[si][pi];
    //         }
    //         memo[si][pi] = -1;
    //         return memo[si][pi];
    //     }

    //     // basic case, no *, just compare to char
    //     if(pi == p.length() - 1 || p.charAt(pi + 1) != '*') {
    //         if(p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si)) {
    //             return isMatch(s, p, si + 1, pi + 1);
    //         } else {
    //             memo[si][pi] = -1;
    //             return memo[si][pi];
    //         }
    //     } 
    //     // * at next position
    //     if(p.charAt(pi) == '.') {
    //         int end = si;
    //         while(end <= s.length()) {
    //             if(isMatch(s, p, end, pi + 2) == 1) {
    //                 memo[si][pi] = 1;
    //                 return memo[si][pi];
    //             }
    //             end++;
    //         }
    //         memo[si][pi] = -1;
    //         return memo[si][pi];
    //     } else if(p.charAt(pi) == s.charAt(si)) {
    //         int end = si;
    //         while(end < s.length() && s.charAt(end) == s.charAt(si)) {
    //             if(isMatch(s, p, end, pi + 2) == 1) {
    //                 memo[si][pi] = 1;
    //                 return memo[si][pi];
    //             }
    //             end++;
    //         }
    //         memo[si][pi] = isMatch(s, p, end, pi + 2);
    //         return memo[si][pi];
    //     }
    //     //""ab"\n".*""
    //     //"""\n"c*c*""
    //     memo[si][pi] = isMatch(s, p, si, pi + 2);
    //     return memo[si][pi];
    // }
    //""ab"\n".*""
}
// @lc code=end

