import java.util.Arrays;

class Solution2 {
    public String longestPalindrome(String s) {
        // using dp, dp[i] is the longest palindrome string that ends with s(i)
        int len = s.length();
        if(len <= 1) return s;
        int maxLen = 0;
        String res = "";
        int[][] dp = new int[len][len];
        for(int gap = 0; gap < len; gap++){
            for(int i = 0; i < len; i++){
                int j = i+gap;
                if(j < len){
                    if(s.charAt(i) == s.charAt(j)){
                        if(gap == 0) dp[i][j] = 1;
                        else if(gap == 1) dp[i][j] = 2;
                        else if(dp[i+1][j-1] == j-i-1) dp[i][j] = dp[i+1][j-1]+2;
                    }
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        System.out.println(s.longestPalindrome("abccba"));
    }
}