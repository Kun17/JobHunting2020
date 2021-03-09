import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Try to use sliding window technique
        // if p.length is len, we can have len different starting point
        // every stride is len as well
        // so in the end Complexity is sLen/len*len, O(sLen) time
        // Actually O(sLen) * checktime
        Map<Character, Integer> pcMap = new HashMap<>();
        for(char c: p.toCharArray()){
            pcMap.put(c, pcMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int len = p.length(), sLen = s.length();
        int i = 0, j = 0, lenCount = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        while(j < sLen){
            char c = s.charAt(j);
            if(!pcMap.containsKey(c)){
                ++j;
                i = j;
                lenCount = 0;
                countMap.clear();
                continue;
            }
            ++lenCount;
            int count = countMap.getOrDefault(c, 0) + 1;
            if(count > pcMap.get(c)){
                while(s.charAt(i) != c && i <= j) {
                    char ic = s.charAt(i);
                    countMap.put(ic, countMap.get(ic) - 1);
                    ++i;
                    --lenCount;
                }
                ++i;
                --count;
                --lenCount;
            }
            countMap.put(c, count);
            if(lenCount == len) {
                res.add(i); 
                char ic = s.charAt(i);
                countMap.put(ic, countMap.get(ic) - 1);
                i++;
                --lenCount;
            }
            ++j;            
        }
        return res;
    }

    public static void main(String[] Args){
        Solution slt = new Solution();
        String s = "abaacbabc";
        String p = "abc";
        System.out.println(slt.findAnagrams(s,p).toString());
    }
}