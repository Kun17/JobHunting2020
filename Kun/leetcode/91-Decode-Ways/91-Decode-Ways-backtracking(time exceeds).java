class Solution1 {
    // "11106"
    // "1106"
    // "106" -> "1"
    // "06"
    // "106" -> "10"
    // "6" 

    // time complexity: n + (n-1) + (n-2) +... O(n^2)
    // space complexity: O(n^2)
    int times = 0;
    public int numDecodings(String s) {
        backtracking(s, 0);
        return times;
    }

    private void backtracking(String s, int start){
        if(start == s.length()) {times++;return;}
        for(int i = start + 1; i <= 2 + start && i <= s.length(); i++){
            if(isValid(s.substring(start, i))){
                backtracking(s, i);
            }
        }
    }

    private boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        int val = Integer.valueOf(s);
        return val >= 1 && val <= 26;
    }
}