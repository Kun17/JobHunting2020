class Solution {
    public int longestPalindrome(String word1, String word2) {
        
        String s = word1 + word2;
        int[][] pal = palindrom(s);
        int ret = 0;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = word1.length(); j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    ret = Math.max(ret, pal[i + 1][j - 1] + 2);
                }
            }
        }
        return ret;
//         StringBuilder sb = new StringBuilder(word2);
//         word2 = sb.reverse().toString();
//         int[][] pal1 = palindrom(word1);
//         int[][] pal2 = palindrom(word2);
//         int n1 = word1.length(), n2 = word2.length();
//         int[][] dp = new int[n1][n2];
//         boolean foundMatch = false;
//         for (int i = 0; i < n1; i++) {
//             if (word2.charAt(0) == word1.charAt(i)) {
//                 foundMatch = true;
//             }
//             if (foundMatch) {
//                 dp[i][0] = 1;
//             }
//         }
        
//         foundMatch = false;
//         for (int j = 0; j < n2; j++) {
//             if (word1.charAt(0) == word2.charAt(j)) {
//                 foundMatch = true;
//             }
//             if (foundMatch) {
//                 dp[0][j] = 1;
//             }
//         }
        
//         for (int i = 1; i < n1; i++) {
//             for (int j = 1; j < n2; j++) {
//                 if (word1.charAt(i) == word2.charAt(j)) {
//                     dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
//                 }
//                 dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
//                 dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
//             }
//         }
        
//         int ret = dp[n1 - 1][n2 - 1] * 2;
//         for (int i = 1; i < n1; i++) {
//             // if (i == 2) {
//             //     System.out.println(dp[i - 1][n2 - 1]);
//             //     System.out.println(pal1[i][n1 - 1]);
//             // }
//             if (dp[i - 1][n2 - 1] != 0) {
//                 ret = Math.max(ret, dp[i - 1][n2 - 1] * 2 + pal1[i][n1 - 1]);
//             }
//         }
        
//         for (int j = 1; j < n2; j++) {
//             if (dp[n1 - 1][j - 1] != 0) {
//                 ret = Math.max(ret, dp[n1 - 1][j - 1] * 2 + pal2[j][n2 - 1]);
//             }
//         }
//         return ret;
    }
    
    public int[][] palindrom(String s) {
        int[][] pal = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            pal[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    pal[i][j] = Math.max(pal[i][j], pal[i + 1][j - 1] + 2);
                }
                pal[i][j] = Math.max(pal[i][j], pal[i + 1][j]);
                pal[i][j] = Math.max(pal[i][j], pal[i][j - 1]);
            }
        }
        return pal;
    }
}
