/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<String>();
        Set<Character> setCh1 = new HashSet<Character>();
        Set<Character> setCh2 = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            setCh1.add(s.charAt(i));
        }
        for(String word: wordDict) {
            for(int i = 0; i < word.length(); i++) {
                setCh2.add(word.charAt(i));
            }
            set.add(word);
        }
        if(setCh1.size() > setCh2.size()) return new ArrayList<String>();
        // System.out.println(set);
        List<String>[] dp = new ArrayList[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            dp[i] = new ArrayList<String>();
            for(int j = 0; j <= i; j++) {
                if(!set.contains(s.substring(j, i + 1))) {
                    continue;
                }
                // System.out.println(s.substring(j, i + 1));
                String curS = s.substring (j, i + 1);
                if(j == 0) {
                    // System.out.println("add " + curS);
                    dp[i].add(curS);
                } else if(dp[j - 1].size() > 0) {
                    for(String prevS : dp[j - 1]) {
                        // System.out.println(prevS + " " + curS);
                        dp[i].add(prevS + " " + curS);
                    }
                }
            }
        }

        return dp[s.length() - 1];

        // Set<String> set = new HashSet<String>(wordDict);
        // // System.out.println(set);
        // Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        // for(int i = 0; i < s.length(); i++) {
        //     List<String> list = new ArrayList<String>();
        //     for(int j = 0; j <= i; j++) {
        //         if(!set.contains(s.substring(j, i + 1))) {
        //             continue;
        //         }
        //         // System.out.println(s.substring(j, i + 1));
        //         String curS = s.substring(j, i + 1);
        //         if(j == 0) {
        //             // System.out.println("add " + curS);
        //             list.add(curS);
        //         } else if(map.get(s.substring(0, j)).size() > 0) {
        //             for(String prevS : map.get(s.substring(0, j))) {
        //                 // System.out.println(prevS + " " + curS);
        //                 list.add(prevS + " " + curS);
        //             }
        //         }
        //     }
        //     map.put(s.substring(0, i + 1), list);
        // }

        // return map.get(s);
    }
}
// @lc code=end
