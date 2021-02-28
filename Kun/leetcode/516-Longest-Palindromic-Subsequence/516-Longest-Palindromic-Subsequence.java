import java.util.Arrays;
class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(0, s.length()-1,s);
    }
    private int helper(int start, int end, String s){
        if(start == end) return 1;
        if(start > end) return 0;
        if(s.charAt(start) == s.charAt(end)) return helper(start+1, end-1, s)+2;
        else return Math.max(helper(start+1, end, s), helper(start, end-1, s));
    }

    public static void main(String[] Args){
    }
}