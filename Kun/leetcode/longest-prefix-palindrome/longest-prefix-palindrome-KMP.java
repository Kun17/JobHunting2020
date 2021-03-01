class Solution{
    public String trimString(String s){
        int len = s.length();
        int[][] dp = new int[len][len];
        int[] maxPrefixDP = new int[len];
        for(int i = len-1; i>=0; i--){
            dp[i][i] = 1;
            int curMaxLen = 1;
            for(int j = i+1; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == j-i-1) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                curMaxLen = Math.max(dp[i][j], curMaxLen);
            }
            maxPrefixDP[i] = curMaxLen;
        }

        int p = 0;
        while(p < len){
            if(maxPrefixDP[p] == 1) break;
            p += maxPrefixDP[p];
        }
        return p == len ? "": s.substring(p);
    }

    public int LongestPalindromicPrefix(String s){
        int len = s.length();
        String newS = s + "?" + new StringBuilder(s).reverse().toString();
        int[] lps = buildLPS(newS);
        return lps[2*len];
    }

    public int searchForPattern(String s, String p){
        int[] lps = buildLPS(p);
        int i = 0, j = 0;
        int len = s.length();
        while(i < len){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else {
                if(j!=0){
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
            if(j == lps.length) return i - j;
        }
        return -1;
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

    Node constructTree(String[] vals){
        if(vals.length == 0) return null;
        int idx = 0;
        Node root = new Node(Integer.valueOf(vals[idx++]));
        Queue<Node> queue = new ArrayDeque<>();
        int N = vals.length;

        queue.add(root);
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if (idx < N && vals[idx] != "null") {
                Node l = new Node(Integer.valueOf(vals[idx]));
                curNode.left = l;
                queue.add(l);
            }
            idx++;
            if (idx < N && vals[idx] != "null") {
                Node r = new Node(Integer.valueOf(vals[idx]));
                curNode.right = r;
                queue.add(r);
            }
            idx++;
        }
        return root;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.trimString("aaabbbxyz"));
        System.out.println(s.LongestPalindromicPrefix("aabaa"));
        System.out.println(s.searchForPattern("abbccabbcc", "bc"));
    }
}