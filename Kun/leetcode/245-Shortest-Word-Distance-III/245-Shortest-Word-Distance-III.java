import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> locMap = new HashMap<>();
        int len = wordsDict.length;
        for(int i = 0; i < len; i++){
            locMap.computeIfAbsent(wordsDict[i], l -> new ArrayList<>()).add(i);
        }
        List<Integer> locL1 = locMap.get(word1);
        List<Integer> locL2 = locMap.get(word2);
        int len1 = locL1.size(), len2 = locL2.size();
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        while(i < len1 && j < len2){
            if(locL1.get(i) == locL2.get(j)){
                j++;
            }
            if(j >= len2) break; 
            minDiff = Math.min(minDiff, Math.abs(locL1.get(i) - locL2.get(j)));
            if(locL1.get(i) < locL2.get(j)){
                i++;
            } else {
                j++;
            }
        }
        return minDiff;
    }
}