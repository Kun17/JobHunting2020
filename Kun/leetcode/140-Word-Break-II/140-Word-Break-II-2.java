import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution2 {
    Map<Integer, ArrayList<String>> memo;
    Set<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return dfs(s, 0);
    }

    ArrayList<String> dfs(String s, int pos){
        //if(memo.containsKey(pos))
        if(memo.containsKey(pos)) return memo.get(pos);
        ArrayList<String> res = new ArrayList<>();
        for(int i = pos; i <= s.length(); i++){
            String substring = s.substring(pos, i);
            ArrayList<String> ans = new ArrayList<>();
            if(dict.contains(substring)){
                if(i < s.length()){
                    ans.addAll(dfs(s, i));
                    for(int j = 0; j < ans.size(); j++){
                        ans.set(j, substring + " " + ans.get(j));
                    }
                } else {
                    ans.add(substring);
                }
            }
            res.addAll(ans);
        }
        memo.put(pos, res);
        return res;
    }

    public static void main(String[] Args){
        List<String> wordDict = new ArrayList<>(Arrays.asList(new String[]{"cat","cats","and","sand","dog"}));
        Solution2 s = new Solution2();
        System.out.println(s.wordBreak("catsanddog", wordDict).toString());
    }
}