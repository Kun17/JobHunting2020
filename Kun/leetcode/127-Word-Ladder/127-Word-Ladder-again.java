import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wordTransMap = new HashMap<>();
        Map<String, Set<String>> transWordMap = new HashMap<>();
        List<String> wholeWordList = new ArrayList<>(wordList);
        wholeWordList.add(beginWord);
        wholeWordList.forEach(
            word ->{
                for(int i = 0; i < word.length(); i++){
                    String sub = new StringBuilder(word).replace(i, i+1, "*").toString();
                    Set<String> transSet = wordTransMap.getOrDefault(word, new HashSet<>());
                    Set<String> wordSet = transWordMap.getOrDefault(sub, new HashSet<>());
                    wordSet.add(word);
                    transSet.add(sub);
                    wordTransMap.put(word, transSet);
                    transWordMap.put(sub, wordSet);
                }
            }
        );
        if(!wordTransMap.containsKey(endWord)) return -1;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        int layer = 0;
        while(!q.isEmpty()){
            int size = q.size();
            Set<String> toBeVisited = new HashSet<>();
            layer++;
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                Set<String> nextTrans = wordTransMap.getOrDefault(cur, new HashSet<>());
                for(String trans: nextTrans){
                    Set<String> nextWords = transWordMap.getOrDefault(trans, new HashSet<>());
                    for(String next: nextWords){
                        if(next == endWord) return layer+1;
                        if(!visited.contains(next)){
                            q.add(next);
                            toBeVisited.add(next);
                        }
                    }
                }
            }
            visited.addAll(toBeVisited);
        }
        
        return 0;
    }


    int layerF = 1;
    int layerB = 1;
    Map<String, Set<String>> wordTransMap;
    Map<String, Set<String>> transWordMap;
    String endWord, beginWord;
    int meetFlag = 0;
    public int ladderLength_2Dir_BFS(String beginWord, String endWord, List<String> wordList) {
        wordTransMap = new HashMap<>();
        transWordMap = new HashMap<>();
        this.beginWord = beginWord;
        this.endWord = endWord;
        List<String> wholeWordList = new ArrayList<>(wordList);
        wholeWordList.add(beginWord);
        wholeWordList.forEach(
            word ->{
                for(int i = 0; i < word.length(); i++){
                    String sub = new StringBuilder(word).replace(i, i+1, "*").toString();
                    Set<String> transSet = wordTransMap.getOrDefault(word, new HashSet<>());
                    Set<String> wordSet = transWordMap.getOrDefault(sub, new HashSet<>());
                    wordSet.add(word);
                    transSet.add(sub);
                    wordTransMap.put(word, transSet);
                    transWordMap.put(sub, wordSet);
                }
            }
        );
        if(!wordTransMap.containsKey(endWord)) return 0;
        
        Queue<String> qF = new LinkedList<>();
        qF.add(beginWord);

        Queue<String> qB = new LinkedList<>();
        qB.add(endWord);

        Set<String> visitedF = new HashSet<>();
        visitedF.add(beginWord);  
        Set<String> visitedB = new HashSet<>();
        visitedB.add(endWord);

        while(!qF.isEmpty() || !qB.isEmpty()){
            layerF = meetInTheMiddle(qF, qB, layerF, visitedF, visitedB);
            if(meetFlag == -1) return layerF + layerB - 1;

            layerB = meetInTheMiddle(qB, qF, layerB, visitedB, visitedF);
            if(meetFlag == -1) return layerF + layerB - 1;
        }
        
        return 0;
    }

    private int meetInTheMiddle(Queue<String> q, Queue<String> other, int layer, Set<String> visited, Set<String> visitedOther){
        int size = q.size();
        Set<String> toBeVisited = new HashSet<>();
        for(int i = 0; i < size; i++){
            String cur = q.poll();
            Set<String> nextTrans = wordTransMap.getOrDefault(cur, new HashSet<>());
            for(String trans: nextTrans){
                Set<String> nextWords = transWordMap.getOrDefault(trans, new HashSet<>());
                for(String next: nextWords){
                    if(visitedOther.contains(next)) {
                        meetFlag = -1;
                        return layer+1;
                    }
                    if(!visited.contains(next)){
                        q.add(next);
                        toBeVisited.add(next);
                    }
                }
            }
        }
        visited.addAll(toBeVisited);
        return layer+1;
    }
    public static void main(String[] Args){
        Solution2 s = new Solution2();
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(s.ladderLength_2Dir_BFS("hit", "cog", wordList));
        System.out.println(s.ladderLength("hit", "cog", wordList));
    }
}