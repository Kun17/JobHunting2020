import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class WordDistance {
    Map<String, Integer> distanceMap;
    Map<String, List<Integer>> posMap;
    int len;
    public WordDistance(String[] words) {
        this.distanceMap = new HashMap<>();
        this.posMap = new HashMap<>();
        this.len = words.length;
        for(int i = 0; i < len; i++){
            posMap.computeIfAbsent(words[i], l -> new ArrayList<>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        String key1 = word1 + "*" + word2, key2 = word2 + "*" + word1;
        if(distanceMap.containsKey(key1)) return distanceMap.get(key1);
        if(distanceMap.containsKey(key2)) return distanceMap.get(key2);
        Iterator<Integer> l1 = posMap.get(word1).iterator();
        Iterator<Integer> l2 = posMap.get(word2).iterator();
        int pos1 = l1.next();
        int pos2 = l2.next();
        int dist = Math.abs(pos1 - pos2);
        while(l1.hasNext() || l2.hasNext()){
            int pre1 = pos1;
            while(pos1 < pos2 && l1.hasNext()){
                pre1 = pos1;
                pos1 = l1.next();
            }
            dist = Math.min(dist, Math.min(Math.abs(pos2 - pre1), Math.abs(pos1 - pos2)));
            if(pos1 < pos2 && !l1.hasNext()) break;
            int pre2 = pos2;
            while(pos2 < pos1 && l2.hasNext()){
                pre2 = pos2;
                pos2 = l2.next();
            }
            dist = Math.min(dist, Math.min(Math.abs(pos1 - pre2), Math.abs(pos2 - pos1)));
            if(pos2 < pos1 && !l2.hasNext()) break;
        }
        distanceMap.put(word1 + "*" + word2, dist);
        return dist;
    }

    public static void main(String[] Args){
        String[] words = new String[]{"practice","makes","perfect","coding","makes"};
        WordDistance wd = new WordDistance(words);
        System.out.println(wd.shortest("coding", "practice"));
        System.out.println(wd.shortest("makes", "coding"));
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */