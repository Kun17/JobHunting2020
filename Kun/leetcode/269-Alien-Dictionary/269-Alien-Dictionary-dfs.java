import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import java.util.HashSet;

class Solution2 {
    Map<Character, List<Character>> reversedGraph;
    private static int DISCOVERED = 1;
    private static int PROCESSED = 2;
    private static int UNDISCOVERED = 0;
    Map<Character, Integer> statusMap;
    StringBuilder res;
    public String alienOrder(String[] words) {
        reversedGraph = new HashMap<>();
        statusMap = new HashMap<>();
        res = new StringBuilder();

        // Find the relations
        int len = words.length;
        for(int i = 0; i < len; i++){
            for(char c: words[i].toCharArray()){
                if(!reversedGraph.containsKey(c)){
                    reversedGraph.put(c, new ArrayList<>());
                    statusMap.put(c, UNDISCOVERED);
                }
            }
        }
        for(int i = 0; i + 1 < len; i++){
            if(!buildEdges(words[i], words[i+1])) return "";
        }

        for(char c: reversedGraph.keySet()){
            if(!dfs(c)) return "";
        }

        return res.toString();
    }

    private boolean dfs(char c){
        if(statusMap.get(c) == PROCESSED) return true;
        if(statusMap.get(c) == DISCOVERED) return false;
        statusMap.put(c, DISCOVERED);
        for(char next: reversedGraph.get(c)){
            if(!dfs(next)) return false;
        }
        statusMap.put(c, PROCESSED);
        res.append(c);
        return true;
    }

    private boolean buildEdges(String small, String large){
        int len = small.length();
        if(len > large.length() && small.startsWith(large)) return false;
        for(int i = 0; i < len; i++){
            char sc = small.charAt(i);
            char lc = large.charAt(i);
            if(sc != lc){
                reversedGraph.get(lc).add(sc);
                return true;
            }
        }
        return true;
    }

    public static void main(String[]  Args){
        Solution2 s = new Solution2();
        String[] words = new String[]{"xc","xa","y"};
        System.out.println(s.alienOrder(words));
    }
}