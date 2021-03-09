import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // Time complexity: if s.length is l, n words in words, length of word is k
    // O(lnk)
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        if(n == 0) return new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        for(int i = 0; i < n; i++){
            dict.put(words[i], dict.getOrDefault(words[i], 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int len = words[0].length(), sLen = s.length();
        for(int i = 0; i < sLen - n * len + 1; i++){
            Map<String, Integer> countMap = new HashMap<>();
            int j = 0;
            while(j < n){
                String sub = s.substring(i + j*len, i+(j+1)*len);
                if(dict.containsKey(sub)){
                    int count = countMap.getOrDefault(sub, 0) + 1;
                    if(count > dict.get(sub)) break;
                    countMap.put(sub, count);
                } else {
                    break;
                }
                j++;
            }
            if(j == n) res.add(i);
        }
        return res;
    }

    public static void main(String[] Args){
        Solution slt = new Solution();
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        System.out.println(slt.findSubstring(s, words).toString());
    }
}