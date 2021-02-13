class Solution2 {
    // "11106"
    // "1106"
    // "106" -> "1"
    // "06"
    // "106" -> "10"
    // "6" 

    // time complexity: O(n)
    // space complexity: O(n^2 + n)
    int times = 0;
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            memo[i] = -1;
        }
        backtracking(s, 0);
        return times;
    }

    //10:
    //start = 0, i = 1
    //start = 1; i = 2
    //memo[1] = 0;
    private void backtracking(String s, int start){
        if(start == s.length()) {times++;return;}
        if(memo[start] != -1) {
            times += memo[start];
        }
        for(int i = start + 1; i <= 2 + start && i <= s.length(); i++){
            if(isValid(s.substring(start, i))){
                backtracking(s, i);
            }
        }
        memo[start] = times;
    }

    private boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        int val = Integer.valueOf(s);
        return val >= 1 && val <= 26;
    }
}