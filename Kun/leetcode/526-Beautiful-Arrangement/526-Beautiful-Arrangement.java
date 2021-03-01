import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    int count = 0;
    int n;
    Map<Integer, List<Integer>> posCandMap;
    public int countArrangement(int n) {
        this.n = n;
        posCandMap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            List<Integer> cand = new ArrayList<>();
            for(int j = i-1; j >= 1; j--){
                if(i%j == 0) cand.add(j);
            }
            for(int j = 1; i * j <= n; j++){
                cand.add(i*j);
            }
            posCandMap.put(i, cand);
        }
        
        Set<Integer> visited = new HashSet<>();
        dfs(1, visited);
        return count;
    }

    private void dfs(int curPos, Set<Integer> visited){
        if(visited.size() == n) {count++; return;}
        for(int cand: posCandMap.getOrDefault(curPos, new ArrayList<>())){
            if(visited.contains(cand)) continue;
            visited.add(cand);
            dfs(curPos+1, visited);
            visited.remove(cand);
        }
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        System.out.println(s.countArrangement(10));
    }
}