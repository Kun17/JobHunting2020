import java.util.List;
import java.util.ArrayList;

class Solution2 {
    public List<String> letterCombinations(String digits) {
        return dfs(digits, 0);
    }

    List<String> dfs(String digits, int s){
        if(s == digits.length()) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        char c = digits.charAt(s);
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
            List<String> rests = dfs(digits, s+1);
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
        Solution2 s = new Solution2();
        System.out.println(s.letterCombinations("9").toString());
    }
}