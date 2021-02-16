import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution4 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[n];
        int[] indegrees = new int[n];
        Map<Integer, Set<Integer>> prerequisiteMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
            prerequisiteMap.put(i, new HashSet<>());
        }

        int len =  prerequisites.length;
        for(int i = 0; i < len; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            indegrees[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegrees[i] == 0) q.add(i);            
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next: graph[curr]){
                prerequisiteMap.get(next).add(curr);
                prerequisiteMap.get(next).addAll(prerequisiteMap.get(curr));
                indegrees[next]--;
                if(indegrees[next] == 0) q.add(next);
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries){
            if(prerequisiteMap.get(query[1]).contains(query[0])){
                res.add(true);
            } else res.add(false);
        }
        return res;
    }
}