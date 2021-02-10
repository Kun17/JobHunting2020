class Solution2 {

    Boolean[][] memo;
    public boolean isMatch_DP(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j){
        if(memo[i][j] != null) return memo[i][j];
        boolean ans;
        if(j >= p.length()) ans = i >= s.length();
        else {
            boolean firstMatch;
            if(i < s.length()) {
                firstMatch = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            } else {
                firstMatch = false;
            }
            if(j+1 < p.length() && p.charAt(j+1) == '*'){
                ans = firstMatch && dp(s, i+1, p, j) || dp(s, i, p, j+2);
            } else {
                return firstMatch && dp(s, i+1, p, j+1);
            }
        }
        memo[i][j] = ans;
        return ans;
    }

    public static void main(String[] Args){
        Solution2 s = new Solution2();
        System.out.println(s.isMatch_DP("aab", "c*a*b"));
    }
}