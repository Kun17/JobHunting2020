import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import java.util.HashSet;

class Solution {
    Map<Character, List<Character>> graph;
    Map<Character, Integer> indegree;
    private static int DISCOVERED = 0;
    private static int PROCESSED = 1;
    public String alienOrder(String[] words) {
        graph = new HashMap<>();
        indegree = new HashMap<>();
        StringBuilder res = new StringBuilder();

        // Find the relations
        int len = words.length;
        for(int i = 0; i < len; i++){
            for(char c: words[i].toCharArray()){
                indegree.put(c, 0);
            }
        }
        for(int i = 0; i + 1 < len; i++){
            if(!buildEdges(words[i], words[i+1])) return "";
        }


        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: indegree.entrySet()){
            if(entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }

        if(q.isEmpty()) return "";
        while(!q.isEmpty()){
            int curSize = q.size();
            for(int i = 0; i < curSize; i++){
                Character curr = q.poll();
                res.append(curr);
                for(Character next: graph.getOrDefault(curr, new ArrayList<>())){
                    int idNext = indegree.get(next) - 1;
                    if(idNext == 0){
                        q.add(next);
                    }
                    indegree.put(next, idNext);
                }
            }
        }

        if(res.length() != indegree.size()) return "";

        return res.toString();
    }

    private boolean buildEdges(String small, String large){
        int len = small.length();
        if(len > large.length() && small.startsWith(large)) return false;
        for(int i = 0; i < len; i++){
            char sc = small.charAt(i);
            char lc = large.charAt(i);
            if(sc != lc){
                List<Character> outNodes = graph.getOrDefault(sc, new ArrayList<>());
                outNodes.add(lc);
                graph.put(sc, outNodes);
                indegree.put(lc, indegree.get(lc) + 1);
                return true;
            }
        }
        return true;
    }

    public static void main(String[]  Args){
        Solution s = new Solution();
        String[] words = new String[]{"abc","ab"};
        System.out.println(s.alienOrder(words));
    }
}