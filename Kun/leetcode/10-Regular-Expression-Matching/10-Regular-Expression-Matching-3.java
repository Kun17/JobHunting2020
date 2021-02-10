class Solution3 {

    boolean[][] memo;
    public boolean isMatch_DP_bottom_up(String s, String p) {
        memo = new boolean[s.length()+1][p.length()+1];
        memo[s.length()][p.length()] = true;

        for(int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' );
                if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                    memo[i][j] = memo[i][j+2] || firstMatch && memo[i+1][j];
                } else {
                    memo[i][j] = firstMatch && memo[i+1][j+1];
                }
            }
        }
        return memo[0][0];
    }

    public static void main(String[] Args){
        Solution3 s = new Solution3();
        System.out.println(s.isMatch_DP_bottom_up("aab", "c*a*b"));
    }
}