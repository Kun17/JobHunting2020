import java.util.Arrays;
class Solution2 {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        memo = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                memo[i][j] = -1;
            }
        }
        return helper(0, len-1,s);
    }
    private int helper(int start, int end, String s){
        if(memo[start][end] != -1) return memo[start][end];
        if(start == end) memo[start][end]=1;
        else if(start < end) {
            if(s.charAt(start) == s.charAt(end)) {
                memo[start][end] = helper(start+1, end-1, s)+2;
            }
            else memo[start][end] = Math.max(helper(start+1, end, s), helper(start, end-1, s));
        }
        return memo[start][end];
    }

    public static void main(String[] Args){
    }
}