import java.util.Arrays;
class Solution3 {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        dp = new int[len][len];
        for(int gap = 0; gap < len; gap++){
            for(int i = 0; i < len; i++){
                int j = i + gap;
                if(j < len){
                    if(i == j) dp[i][j] = 1;
                    else {
                        if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                        else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][len-1];
    }

    public int longestPalindromeSubseq2(String s) {
        int len = s.length();
        dp = new int[len][len];
        for(int i = len -1; i>=0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j<len;j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] Args){
    }
}