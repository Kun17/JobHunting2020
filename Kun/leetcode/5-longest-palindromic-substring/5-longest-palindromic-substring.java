import java.util.HashMap;
import java.util.Map;

class Solution {
    public String longestPalindrome_DP_BottomUp(String s) {
        // Using Dynamic Programming Bottom Up Approach
        // We can build up from the bottom, if the length of string is 2, we only need to check they consist of same letter
        // if length is 1, it is a palindromic string
        Map<Integer, String> lenValMap = new HashMap<>();
        Boolean[][] p = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i ++ ){
            for(int j = 0; j < s.length(); j++) {
                if (i == j) {
                    p[i][j] = true;
                }
                p[i][j] = null;
            }
        }
        int maxLen = 0;

        // Define step
        for (int step = 0; step < s.length(); step ++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + step;
                if (j < s.length()){
                    if (i == j) {p[i][j] = true;}
                    else if(j == i + 1){p[i][j] = (s.charAt(i) == s.charAt(j));}
                    else {
                        p[i][j] = (s.charAt(i) == s.charAt(j)) && p[i+1][j-1];
                    }
                    if ((p[i][j]) && (j - i + 1 > maxLen)) {
                        maxLen = j - i + 1;
                        lenValMap.put(maxLen, s.substring(i, j+1));
                    }
                }
            }
        }
        return lenValMap.get(maxLen);
    }

    public String longestPalindrome_DP_TopDown(String s) {
        // Using Dynamic Programming Top down approach
        // What is the overlapping subproblem
        // We need to find the longest palindromic substring
        // if s[i, j) is a palindromic, which infers s[i+1, j-1] is also a palindromic substring
        // for [i, j), for all x < i and y > j, we visit if substring[i, j) is a palindromic string multiple time
        // So p[i, j) = (s.charAt(i) == s.charAt(j - i))  && p[i+1, j-1)
        // So for top down, we create a boolean matrix storing compute result of it
        // However, the problem asks us to return the actual substirng
        // So we store the length of substring and its value inside a map
        Map<Integer, String> lenValMap = new HashMap<>();
        Boolean[][] p = new Boolean[s.length()][s.length() + 1];
        for (int i = 0; i < s.length(); i ++ ){
            for(int j = 0; j <= s.length(); j++) {
                p[i][j] = null;
            }
        }
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                if (isPalindrome_DP_TopDown(p, s, i, j)) {
                    if (j - i > maxLen) {
                        maxLen = j - i;
                        lenValMap.put(maxLen, s.substring(i, j));
                    }
                }
            }
        }
        return lenValMap.get(maxLen);
    }

    private Boolean isPalindrome_DP_TopDown(Boolean[][] p, String s, int i, int j){
        if(p[i][j] != null){
            return p[i][j];
        }
        if (j == i + 1) {
            p[i][j] = true;
            return true;
        } else if (j == i+ 2){
            if (s.charAt(i) == s.charAt(j - 1)) {
                p[i][j] = true;
            return true;
            }
            p[i][j] = false;
            return false;
        } else {
            Boolean res = isPalindrome_DP_TopDown(p, s, i+1, j-1) && (s.charAt(i) == s.charAt(j-1));
            p[i][j] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long startTimeForTopDown = System.nanoTime();
        String res1 = s.longestPalindrome_DP_TopDown("qagtxztpovdbqrhtftxrfjkrrjnhbkoawjctdiaygmbutzzosisyxwqbufsgbmfbpcxvdibnayximkkdmviorabhjasxyyagqrxzfewimqewftfihlgsqmkoapwckbhdarhlbonypdzhnxcnzanlrjzfixrpepsjmdepgxvyuijonhqnejymwlofzskcfqdyyfowkzhswutsuhwiqkoogeqkcpjrqndeaxqvdadheostwdonphfaemebuqmwdtrioyjtzoprasizwmwfikaihudneusfgdtcpwgzkwnceziayflxrsmydjiwbeqdzcfewedulydcoahgptzzlzldzaazblvzxuvdxhmzbwasfibtkxuylpklpbfmhujcwvmhbylkrxmhgmmrzdanhsvkrlwqctoexcmhughsvcqgdxxnvcawrroebqylnelyodxfkrplprldsjeejsdlrplprkfxdoylenlyqbeorrwacvnxxdgqcvshguhmcxeotcqwlrkvshnadzrmmghmxrklybhmvwcjuhmfbplkplyuxktbifsawbzmhxdvuxzvlbzaazdlzlzztpghaocdyludewefczdqebwijdymsrxlfyaizecnwkzgwpctdgfsuenduhiakifwmwzisarpoztjyoirtdwmqubemeafhpnodwtsoehdadvqxaednqrjpckqegookqiwhustuwshzkwofyydqfckszfolwmyjenqhnojiuyvxgpedmjspeprxifzjrlnazncxnhzdpynoblhradhbkcwpaokmqsglhiftfweqmiwefzxrqgayyxsajhbaroivmdkkmixyanbidvxcpbfmbgsfubqwxysisozztubmgyaidtcjwaokbhnjrrkjfrxtfthrqbdvoptzxtgaq");
        long endTimeForTopDown = System.nanoTime();
        System.out.println(res1);
        System.out.println("Execution time for topDown in ms:" + (endTimeForTopDown - startTimeForTopDown)/1000000);

        long startTimeForBottomUp = System.nanoTime();
        String res2 = s.longestPalindrome_DP_BottomUp("qagtxztpovdbqrhtftxrfjkrrjnhbkoawjctdiaygmbutzzosisyxwqbufsgbmfbpcxvdibnayximkkdmviorabhjasxyyagqrxzfewimqewftfihlgsqmkoapwckbhdarhlbonypdzhnxcnzanlrjzfixrpepsjmdepgxvyuijonhqnejymwlofzskcfqdyyfowkzhswutsuhwiqkoogeqkcpjrqndeaxqvdadheostwdonphfaemebuqmwdtrioyjtzoprasizwmwfikaihudneusfgdtcpwgzkwnceziayflxrsmydjiwbeqdzcfewedulydcoahgptzzlzldzaazblvzxuvdxhmzbwasfibtkxuylpklpbfmhujcwvmhbylkrxmhgmmrzdanhsvkrlwqctoexcmhughsvcqgdxxnvcawrroebqylnelyodxfkrplprldsjeejsdlrplprkfxdoylenlyqbeorrwacvnxxdgqcvshguhmcxeotcqwlrkvshnadzrmmghmxrklybhmvwcjuhmfbplkplyuxktbifsawbzmhxdvuxzvlbzaazdlzlzztpghaocdyludewefczdqebwijdymsrxlfyaizecnwkzgwpctdgfsuenduhiakifwmwzisarpoztjyoirtdwmqubemeafhpnodwtsoehdadvqxaednqrjpckqegookqiwhustuwshzkwofyydqfckszfolwmyjenqhnojiuyvxgpedmjspeprxifzjrlnazncxnhzdpynoblhradhbkcwpaokmqsglhiftfweqmiwefzxrqgayyxsajhbaroivmdkkmixyanbidvxcpbfmbgsfubqwxysisozztubmgyaidtcjwaokbhnjrrkjfrxtfthrqbdvoptzxtgaq");
        long endTimeForBottomUp = System.nanoTime();
        System.out.println(res2);
        System.out.println("Execution time for topDown in ms:" + (endTimeForBottomUp - startTimeForBottomUp)/1000000);

    }
}