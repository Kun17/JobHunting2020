import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    //Map<Integer, List<String>> memo;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        StringBuilder sb = new StringBuilder();
        res = new ArrayList<>();
        dfs(s, 0, dict, sb);
        return res;
    }

    void dfs(String s, int pos, Set<String> dict, StringBuilder sb){
        //if(memo.containsKey(pos))
        if(pos == s.length()){
            res.add(sb.toString().substring(1, sb.length()));
        }
        for(int i = pos; i <= s.length(); i++){
            String substring = s.substring(pos, i);
            if(dict.contains(substring)){
                sb.append(" ");
                sb.append(substring);
                dfs(s, i, dict, sb);
                sb.delete(sb.length() - 1 - substring.length(), sb.length());
            }
        }
    }
}