import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if(len == 0) return new ArrayList<>();
        char c = digits.charAt(0);
        int upperBound = 3;
        int base = (c - '2')*3;
        if(c == '9' || c == '7'){
            upperBound = 4;
        } 
        if (c == '8' || c == '9'){
            base += 1;
        }
        for (int j = 0; j < upperBound; j++){
            char lead = (char)(base + j + 'a');
            List<String> rests = letterCombinations(digits.substring(1, len));
            if(rests.size() == 0) res.add(String.valueOf(lead));
            else {
                for(String rest: rests){
                    String ans = lead + rest;
                    res.add(ans);
                }
            }
        }
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.letterCombinations("9").toString());
    }
}