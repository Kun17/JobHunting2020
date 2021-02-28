import java.util.Stack;

class Solution3 {
    public int longestValidParentheses(String s) {
        int res = 0;
        int len = s.length();
        int[] dp = new int[len];
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '(') dp[i] = i-2>=0?dp[i-2]:0+2;
                else if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0?dp[i-dp[i-1]-2]:0);
                    }
                }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] Args){
        Solution3 s = new Solution3();
        System.out.println(s.longestValidParentheses(")()())"));
    }
}