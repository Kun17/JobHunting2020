import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    Map<Integer, List<Integer>> graph;
    boolean[] checked;
    Set<List<Integer>> criticalConns;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.graph = new HashMap<>();
        this.checked = new boolean[n];

        for(List<Integer> r: connections){
            insert(r);
        }

        this.criticalConns = new HashSet<>();
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            dfs(i, -1, visited);
        }
        return new ArrayList<>(criticalConns);
    }

    boolean dfs(int i, int parent, boolean[] visited){
        if(checked[i]) return false;
        if(visited[i]) return true;
        visited[i] = true;
        
        boolean isCyclic = false;
        for(int next: graph.getOrDefault(i, new ArrayList<>())){
            if(next != parent && !checked[next]){
                List<Integer> l = new LinkedList<>();
                l.add(i);
                l.add(next);
                System.out.println("add: "+ l.toString());
                criticalConns.add(l);
                if(dfs(next, i, visited)) {
                    isCyclic = true;
                    criticalConns.remove(l);
                    System.out.println("remove: "+ l.toString());
                }
            }
        }
        visited[i] = false;
        checked[i] = true;
        return isCyclic;
    }

    void insert(List<Integer> relation){
        int u = relation.get(0);
        int v = relation.get(1);
        List<Integer> uAdjs = graph.getOrDefault(u, new ArrayList<>());
        uAdjs.add(v);
        graph.put(u, uAdjs);
        List<Integer> vAdjs = graph.getOrDefault(v, new ArrayList<>());
        vAdjs.add(u);
        graph.put(v, vAdjs);
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
        int[][] data = new int[][]{{0,1},{1,2},{2,0},{1,3}};
        List<List<Integer>> connections = s.buildInput(data);
        String res = s.criticalConnections(4, connections).toString();
        System.out.println(res);
    }
}