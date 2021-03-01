class Solution {
    public String shortestPalindrome(String s) {
        int x = longestPrefixPalindrome(s);
        return new StringBuilder(s.substring(x)).reverse().append(s).toString();        
    }

    private int longestPrefixPalindrome(String s){
        int len = s.length();
        String newS = s + "?" + new StringBuilder(s).reverse().toString();
        int[] lps = buildLPS(newS);
        return lps[2*len];
    }

    private int[] buildLPS(String s){
        int len = s.length();
        int[] lps = new int[len];
        int i = 0, j = 1;
        while(j < len){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else {
                if(i != 0){
                    i = lps[i-1];
                } else {
                    j++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.shortestPalindrome("acaa"));
    }
}