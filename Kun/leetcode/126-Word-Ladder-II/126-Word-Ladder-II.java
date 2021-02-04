import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

class Solution {
    class node {
        String word;
        Integer level;
        List<String> path;
        node(String word, Integer level, List<String> path){this.word = word; this.level = level; this.path = path;}
    }
    int L;
    Map<String, List<String>> trsToOrgMap;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Because all the words should have the same length, we only need to store it once
        // We make it a protected var of this class to be accessible to every funcs
        this.L = beginWord.length();
        this.trsToOrgMap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        // We create a map, that with every transformed word, we can get the possible original word
        wordList.forEach(
            word -> {
                for(int i = 0; i < L; i++){
                    String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                    List<String> orgs = trsToOrgMap.getOrDefault(newWord, new ArrayList<String>());
                    orgs.add(word);
                    trsToOrgMap.put(newWord, orgs);
                }
            }
        );
        
        // We cannot use 2 dir BFS, because we need to iterate through the shortest level anyway
        Map<String, Integer> visited = new HashMap<>();
        // We need two Qs to do 2 dir BFS
        Queue<node> Q = new LinkedList<>();
        node beginNode = new node(beginWord, 0, new ArrayList<>());
        beginNode.path.add(beginWord);
        Q.add(beginNode);
        visited.put(beginWord, 0);
        boolean reachedLastLevel = false;
        int lastLevel = 0;
        while(!Q.isEmpty()){
            node curNode = Q.poll();
            String curWord = curNode.word;
            if(reachedLastLevel) {
                if(curNode.level > lastLevel) break;
            }
            for(int i = 0; i < L; i++){
                String newWord = curWord.substring(0, i) + "*" + curWord.substring(i+1, L);
                for(String next: trsToOrgMap.getOrDefault(newWord, new ArrayList<>())){
                    if(next.equals(endWord)){
                        if(!reachedLastLevel) lastLevel = curNode.level;
                        reachedLastLevel = true;
                        List<String> path = new ArrayList<String>(curNode.path);
                        path.add(next);
                        res.add(path);
                        continue;
                    }
                    if(!visited.containsKey(next) || visited.get(next) == (curNode.level+1)){
                        visited.put(next, curNode.level+1);
                        List<String> newPath = new ArrayList<>(curNode.path);
                        newPath.add(next);
                        Q.add(new node(next, curNode.level+1, newPath));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        String beginWord = "red";
        String endWord = "tax";
        List<String>  wordList = Arrays.asList(new String[]{"ted","tex","red","tax","tad","den","rex","pee"});
        System.out.println(s.findLadders(beginWord, endWord, wordList));
    }
}