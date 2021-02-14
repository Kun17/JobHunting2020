class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--) {
            isPalindrome[i][i] = true;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i + 1 == j || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
        boolean[] dp = new boolean[n];
        for(int i = 1; i < n - 1; i++) {
            for(int j = i; j < n - 1; j++) {
                if(isPalindrome[0][i - 1] && isPalindrome[i][j] && isPalindrome[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean valid(int i, int j, String s) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

