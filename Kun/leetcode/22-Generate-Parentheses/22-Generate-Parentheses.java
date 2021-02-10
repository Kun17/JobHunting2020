import java.util.List;
import java.util.ArrayList;

class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        StringBuilder sb =  new StringBuilder();
        res = new ArrayList<>();
        helper(n, 0, 0, sb);
        return res;
    }

    void helper(int n, int left, int right, StringBuilder path){
        if(left == right && left == n){
            res.add(new String(path));
        }

        if(left >= right && left < n){
            path.append("(");
            helper(n, left + 1, right, path);
            path.deleteCharAt(path.length() - 1);
        }
        if(left > right && left <= n){
            path.append(")");
            helper(n, left, right+1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}