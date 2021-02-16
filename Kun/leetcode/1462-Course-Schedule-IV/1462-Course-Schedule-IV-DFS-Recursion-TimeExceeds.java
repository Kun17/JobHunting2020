import java.util.List;
import java.util.ArrayList;

class Solution2 {
    ArrayList<Integer>[] graph;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        int len =  prerequisites.length;
        for(int i = 0; i < len; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries){
            res.add(dfs(query[0], query[1]));
        }

        return res;
    }

    private boolean dfs(int src, int target){
        if(src == target) return true;
        List<Integer> adjs = graph[src];
        for(int adj: adjs){
            if(dfs(adj, target)) return true;
        }
        return false;
    }
}