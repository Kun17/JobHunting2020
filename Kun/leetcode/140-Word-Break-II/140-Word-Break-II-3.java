import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution3 {
    Map<Integer, ArrayList<String>> memo;
    Set<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return dp_bottom_up(s);
    }

    ArrayList<String> dp_bottom_up(String s){
        for(int i = s.length()-1; i >= 0; i--){
            ArrayList<String> res = new ArrayList<>();
            for(int j = i+1; j <= s.length(); j++){
                ArrayList<String> ans = new ArrayList<>();
                String substring = s.substring(i, j);
                if(dict.contains(substring)){
                    if(memo.containsKey(j)){
                        ans = new ArrayList<>(memo.get(j));
                        for(int k = 0; k < ans.size(); k++){
                            ans.set(k, substring + " " + ans.get(k));
                        }
                    } else if(j == s.length()) {
                        ans.add(substring);
                        //memo.put(i, ans);
                    }
                }
                if(ans.size() > 0) res.addAll(ans);
            }
            if(res.size() > 0) memo.put(i, res);
        }
        return memo.getOrDefault(0, new ArrayList<>());
    }

    public static void main(String[] Args){
        List<String> wordDict = new ArrayList<>(Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
        Solution3 s = new Solution3();
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict).toString());
    }
}