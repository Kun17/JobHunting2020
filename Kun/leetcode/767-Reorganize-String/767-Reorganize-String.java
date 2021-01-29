import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
    class charCount {
        Character val;
        Integer count;
        charCount(Character val, Integer count) {this.val = val; this.count = count;}
    }
    public String reorganizeString(String S) {
        char[] Cs = S.toCharArray();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c: Cs) {
            charCountMap.put(c, charCountMap.containsKey(c) ? charCountMap.get(c) + 1 : 1);
        }
        int len = S.length();
        char[] res = new char[len];
        Set<Character> keys = charCountMap.keySet();
        Iterator<Character> it = keys.iterator();
        PriorityQueue<charCount> PQ = new PriorityQueue<>(keys.size(), (a,b) -> Integer.compare(b.count, a.count));
        while(it.hasNext()){
            Character key = it.next();
            if (len % 2 == 0){
                if(charCountMap.get(key) > len/2) return "";
            } else {
                if(charCountMap.get(key) > len/2 + 1) return "";
            }
            PQ.add(new charCount(key, charCountMap.get(key)));
        }

        int i = 0;
        while (!PQ.isEmpty()){
            charCount curCC = PQ.poll();
            for(int j = 0; j < curCC.count; j++){
                if (i >= len) i = 1;
                res[i] = curCC.val;
                i += 2;
            }
        }
        return new String(res);
    }

    public String reorganizeString_better(String S) {
        char[] Cs = S.toCharArray();
        int[] counts = new int[26];
        for (char c: Cs) {
            counts[c - 'a']++;
        }

        int maxCount = 0;
        int maxLetter = 0;
        for (int i = 0; i < 26; i++){
            if (counts[i] > maxCount){
                maxCount = counts[i];
                maxLetter = i;
            }
        }

        int len = S.length();

        if (maxCount > (len % 2 == 0? len/2 : (len/2 + 1))){
            return "";
        }

        char[] res = new char[len];
        int i = 0;
        for (int j = 0; j < maxCount; j++) {
            res[i] = (char)(maxLetter + 'a');
            counts[maxLetter]--;
            i += 2;
        }

        for (int j = 0; j < 26; j++){
            for(int k = 0; k < counts[j]; k++){
                if(i >= len) i=1;
                res[i] = (char)(j + 'a');
                i+=2;
            }
        }
        return new String(res);
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.reorganizeString_better("vvvlo"));
    }
}