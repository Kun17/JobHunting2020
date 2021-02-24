import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    Map<Character, Integer> cCountMap;
    List<Integer> res;
    Set<Character> exist;
    public List<Integer> partitionLabels(String S) {
        cCountMap = new HashMap<>();
        res = new ArrayList<>();
        for(char c: S.toCharArray()){
            cCountMap.put(c, cCountMap.getOrDefault(c, 0) + 1);
        }
        exist = new HashSet<>();
        find(S, 0);
        return res;
    }

    private void find(String S, int start){
        int end = 0;
        if(start >= S.length()) return;
        for(int i = start; i < S.length(); i++){
            char c = S.charAt(i);
            exist.add(c);
            int count = cCountMap.get(c);
            count--;
            if(count == 0) {cCountMap.remove(c);exist.remove(c);}
            else cCountMap.put(c, count);
            if(exist.isEmpty()) {end = i;break;}
        }
        res.add(end - start + 1);
        find(S, end + 1);
    }
}