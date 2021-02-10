import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    List<Integer>[] graph;
    int[] rank;
    Set<List<Integer>> resSet;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        rank = new int[n];
        resSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
            rank[i] = -1;
        }
        for(List<Integer> con : connections){
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }

        dfs(0, 0);
        return new ArrayList<>(resSet);
    }

    int dfs(int curr, int parentRank){
        int n = rank.length;
        // This indicates this node has been visited in the current dfs
        // Or has been checked
        // We assign rank to n when it's visited or checked
        if(rank[curr] != -1) return rank[curr];

        int currRank = parentRank + 1;
        rank[curr] = currRank;
        int minRank = currRank;
        for(int next: graph[curr]){
            // skip it of next node is checked or it is parent, same way back
            if(rank[next] == parentRank || rank[next] == n) continue;
            int nextRank = dfs(next, currRank);
            // This indicates next node is not a part of a cycle
            // Add it to the result
            if (nextRank > currRank) {
                List<Integer> path = new ArrayList<>();
                path.add(curr);
                path.add(next);
                resSet.add(path);
            }
            minRank = Math.min(nextRank, minRank);
        }
        rank[curr] = n;
        return minRank;
    }

    List<List<Integer>> buildInput(int[][] data){
        List<List<Integer>> res = new ArrayList<>();
        for(int[] d: data){
            List<Integer> r = new ArrayList<>();
            for(int i: d){
                r.add(i);
            }
            res.add(r);
        }
        return res;
    }

    public static void main(String[] Args){
        Solution s = new Solution();
        int[][] data = new int[][]{{0,2},{1,2},{2,3}};
        List<List<Integer>> connections = s.buildInput(data);
        String res = s.criticalConnections(6, connections).toString();
        System.out.println(res);
    }
}