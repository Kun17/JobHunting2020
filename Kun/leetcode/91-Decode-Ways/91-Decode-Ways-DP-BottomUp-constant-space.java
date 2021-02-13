class Solution3 {
    // "11106"
    // "1106"
    // "106" -> "1"
    // "06"
    // "106" -> "10"
    // "6" 

    // time complexity: O(n)
    // space complexity: O(n)
    

    // "12"
    // "2" [0, 1, 1]
    // i = 1, j = 1
    int backOne = 1, backTwo = 1;
    public int numDecodings(String s) {
        memo = new int[s.length()+1];
        memo[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            if(isValid(s.substring(i, i+1))){
                if(isValid(s.substring(i, i+1))){
                    
                }
            }
            for(int j = 1; j <= 2 && i+j <= s.length(); j++){
                if(isValid(s.substring(i, i+j))){
                    memo[i] += memo[i+j];
                }
            }
        }
        return memo[0];
    }

    //10:
    //start = 0, i = 1
    //start = 1; i = 2
    //memo[1] = 0;

    private boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        int val = Integer.valueOf(s);
        return val >= 1 && val <= 26;
    }
}