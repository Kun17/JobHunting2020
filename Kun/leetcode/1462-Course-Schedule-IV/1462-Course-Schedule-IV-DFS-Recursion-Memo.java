import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer>[] graph;
    int[][] dp;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
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
        if(dp[src][target] != -1) return dp[src][target] == 1;
        List<Integer> adjs = graph[src];
        for(int adj: adjs){
            if(dfs(adj, target)) {
                dp[src][target] = 1;
                dp[adj][target] = 1;
                return true;
            } else {
                dp[adj][target] = 0;
            }
        }
        dp[src][target] = 0;
        return false;
    }
}