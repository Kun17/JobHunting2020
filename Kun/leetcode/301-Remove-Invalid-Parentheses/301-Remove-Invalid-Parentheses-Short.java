import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution2 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(',')'});
        return ans;
    }

    private void remove(String s, List<String> ans, int lastPicked, int curVio, char[] rule){
        for(int stack =0, i = curVio; i < s.length(); ++i){
            if(s.charAt(i) == rule[0]) stack++;
            if(s.charAt(i) == rule[1]) stack--;
            if(stack >= 0) continue;
            for(int j = lastPicked; j <= i ; ++j){
                if(s.charAt(j) == rule[1] && (j == lastPicked || s.charAt(j-1) != rule[1])){
                    remove(s.substring(0, j) + s.substring(j+1, s.length()), ans, j, i, rule);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(rule[0] == '('){
            remove(reversed, ans, 0,0,new char[]{')','('});
        } else {
            ans.add(reversed);
        }
    }


    public static void main(String[] Args){
        Solution2 s = new Solution2();
        System.out.println(s.removeInvalidParentheses("(((k()(("));
    }
}